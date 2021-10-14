package com.he.excise.redis.article.basic;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.*;

public class OneArticleVote {
    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 400;
    private static final int ARTICLES_PER_PAGE = 25;

    public static final void main(String[] args) {
        new OneArticleVote().run();
    }

    public void run() {
    	//连接redis
        Jedis jedis = new Jedis("101.133.174.213");
        //访问redis的密码
        jedis.auth("123456789");
        //选择数据库号
        jedis.select(15);
        //发布文章，返回文章ID
        String articleId = postArticle(
            jedis, "James", "一路向东", "www.miguo.com");
        System.out.println("刚发布了一篇文章，文章ID为: " + articleId);
        System.out.println("文章所有属性值内容如下:");
        Map<String,String> articleData = jedis.hgetAll("article:" + articleId);
        for (Map.Entry<String,String> entry : articleData.entrySet()){
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }

        System.out.println();

        System.out.println("开始对文章"+"article:" + articleId+"进行投票啦~~~~~");
        //cang用户给James的文章投票
        articleVote(jedis, "teacherCang", "article:" + articleId);
        //投票完后，查询当前文章的投票数votes
        String votes = jedis.hget("article:" + articleId, "votes");
        System.out.println("article:" + articleId+"这篇文章的投票数从redis查出来结果为: " + votes);
        //assert Integer.parseInt(votes) > 1;

        System.out.println("查询当前的文章列表集合为：");
        List<Map<String,String>> articles = getArticles(jedis, 1);
        printArticles(articles);
        //assert articles.size() >= 1;

        addGroups(jedis, articleId, new String[]{"java"});
        System.out.println("文章id"+articleId+"添加java组, 除了此文章外，还有文章信息如下:");
        //获取java组的所有文章
        articles = getGroupArticles(jedis, "java", 1);
        printArticles(articles);
        assert articles.size() >= 1;
    }
    //文章发布，数据初始化…………
    public String postArticle(Jedis jedis, String user, String title, String link) {
    	//文章ID，自增
        String articleId = String.valueOf(jedis.incr("article:"));
        //用来记录投票
        String voted = "voted:" + articleId;
        jedis.sadd(voted, user); //将投票的用户记录到voted:1键集合来……
        jedis.expire(voted, ONE_WEEK_IN_SECONDS); //设置失效时间

        long now = System.currentTimeMillis() / 1000;
        //long score = 0l;
        //生成文章ID
        String article = "article:" + articleId;
        HashMap<String,String> articleData = new HashMap<String,String>();
        articleData.put("title", title);
        articleData.put("link", link);
        articleData.put("user", user);
        articleData.put("now", String.valueOf(now));
        articleData.put("votes", "1");
        //发布一篇文章，hmset article:1 title 银瓶梅 link googlecom user username
        jedis.hmset(article, articleData);
        //zadd user:zan 200 james james的点赞数1, 返回操作成功的条数1
        jedis.zadd("score:", now + VOTE_SCORE, article);//根据分值排序文章的有序集合
        jedis.zadd("time:", now, article); //根据文章发布时间排序文章的有序集合

        return articleId;
    }
    //文章投票， 更新键为score:的集合，分值加1， 同时将文章hash的votes投票数加1
    public void articleVote(Jedis jedis, String user, String article) {
    	//计算投票截止时间
        long cutoff = (System.currentTimeMillis() / 1000) - ONE_WEEK_IN_SECONDS;
        //检查是否还可以对文章进行投票,如果该文章的发布时间比截止时间小，则已过期，不能进行投票
        if (jedis.zscore("time:", article) < cutoff){
            return;
        }

    	//获取文章主键id
        String articleId = article.substring(article.indexOf(':') + 1);
        //将投票的用户加入到键为voted:1的集合中，表示该用户已投过票了
        if (jedis.sadd("voted:" + articleId, user) == 1) {
            jedis.zincrby("score:", VOTE_SCORE, article);//分值加1
            jedis.hincrBy(article, "votes", 1L);//投票数加1
        }
    }


    public List<Map<String,String>> getArticles(Jedis jedis, int page) {
        return getArticles(jedis, page, "score:");
    }

    public List<Map<String,String>> getArticles(Jedis jedis, int page, String order) {
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;

        Set<String> ids = jedis.zrevrange(order, start, end); //倒序查询出投票数最高的文章
        List<Map<String,String>> articles = new ArrayList<Map<String,String>>();
        for (String id : ids){
            Map<String,String> articleData = jedis.hgetAll(id);
            articleData.put("id", id);
            articles.add(articleData);
        }

        return articles;
    }

    public void addGroups(Jedis jedis, String articleId, String[] toAdd) {
    	//得到article:1
        String article = "article:" + articleId;
        for (String group : toAdd) {
        	//将该键做为group-java集合的元素加入到集合中
            jedis.sadd("group:" + group, article);
        }
    }

    public List<Map<String,String>> getGroupArticles(Jedis jedis, String group, int page) {
        return getGroupArticles(jedis, group, page, "score:");
    }

    public List<Map<String,String>> getGroupArticles(Jedis jedis, String group, int page, String order) {
        String key = order + group;
        if (!jedis.exists(key)) {
        	return null;
           /* ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
            jedis.zinterstore(key, params, "group:" + group, order);
            jedis.expire(key, 60);*/
        }
        return getArticles(jedis, page, key);
    }

    private void printArticles(List<Map<String,String>> articles){
        for (Map<String,String> article : articles){
            System.out.println("  id: " + article.get("id"));
            for (Map.Entry<String,String> entry : article.entrySet()){
                if (entry.getKey().equals("id")){
                    continue;
                }
                System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
