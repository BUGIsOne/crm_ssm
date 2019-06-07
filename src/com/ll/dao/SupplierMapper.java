package com.ll.dao;

import java.util.List;

import com.ll.pojo.Supplier;

public interface SupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

	List<Supplier> selectAllSupplier();

	Supplier findBySnumAndSname(Supplier supplier);
	
	Supplier selectBySname(String sname);
}