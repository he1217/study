package com.he.study.mybatis.entity.mapper;

import com.he.study.mybatis.entity.model.ActivityRule;

public interface ActivityRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActivityRule record);

    int insertSelective(ActivityRule record);

    ActivityRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActivityRule record);

    int updateByPrimaryKey(ActivityRule record);
}