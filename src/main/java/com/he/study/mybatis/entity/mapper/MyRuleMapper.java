package com.he.study.mybatis.entity.mapper;

import com.he.study.mybatis.entity.model.MyRule;

public interface MyRuleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyRule record);

    int insertSelective(MyRule record);

    MyRule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyRule record);

    int updateByPrimaryKey(MyRule record);
}