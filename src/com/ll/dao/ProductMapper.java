package com.ll.dao;

import java.util.List;

import com.ll.pojo.Customer;
import com.ll.pojo.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    Product findByPnumAndSid(Product record);
    
	List<Product> selectAllProduct();
	
	Product selectByPname(String pname);
}