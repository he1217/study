
package com.james.cache.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.james.cache.dao.ArticleDao;
import com.james.cache.service.ArticleService;

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

