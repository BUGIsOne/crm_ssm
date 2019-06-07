package com.ll.dao;

import java.util.List;

import com.ll.pojo.Stock_in;
import com.ll.pojo.Stock_out;

public interface Stock_outMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock_out record);

    int insertSelective(Stock_out record);

    Stock_out selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stock_out record);

    int updateByPrimaryKey(Stock_out record);

	List<Stock_out> selectAllStock_out();
	//根据产品编号的到出货量
    Stock_out selectByPnum(String pnum);
}