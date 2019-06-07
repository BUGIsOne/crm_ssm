package com.ll.dao;

import com.ll.pojo.Stock_in;

public interface Stock_inMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock_in record);

    int insertSelective(Stock_in record);

    Stock_in selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock_in record);

    int updateByPrimaryKey(Stock_in record);
}