package com.ll.service;

import java.util.List;

import com.ll.pojo.Customer;


public interface CustomerService {

	void updateCustomer(Customer customer);
	List<Customer> getCustomers();
	Customer findCustomer(Customer customer);
	Customer findCustomerByCname(String cname);
	void deleteByPrimaryKey(Integer id);
	boolean addCustomer(Customer customer);
}
