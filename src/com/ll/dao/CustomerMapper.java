package com.ll.dao;

import java.util.List;

import com.ll.pojo.Admin;
import com.ll.pojo.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    Customer findByNumAndName(Customer customer);
    
	List<Customer> selectAllCustomer();
	
	Customer selectByCname(String cname);
}