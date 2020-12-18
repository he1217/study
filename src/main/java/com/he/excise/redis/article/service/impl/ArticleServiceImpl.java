
package com.he.excise.redis.article.service.impl;

import java.util.List;
import java.util.Map;

import com.he.excise.redis.article.dao.ArticleDao;
import com.he.excise.redis.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	/**
	* 文章查询
	*/
	@Override
	public List<Map> queryArticleVoteByPostTime(String articleId) {
		// TODO Auto-generated method stub
		List<Map> l= articleDao.queryArticleVoteByPostTime(articleId);
		System.out.println("=============="+l.toString());
		return l;
	}

	 

}

