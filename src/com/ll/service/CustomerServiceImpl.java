package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.AdminMapper;
import com.ll.dao.CustomerMapper;
import com.ll.pojo.Admin;
import com.ll.pojo.Customer;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper customerDao;
	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.updateByPrimaryKeySelective(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> list = customerDao.selectAllCustomer();
		return list;
	}

	@Override
	public Customer findCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.findByNumAndName(customer);
	}

	@Override
	public Customer findCustomerByCname(String cname) {
		// TODO Auto-generated method stub
		return customerDao.selectByCname(cname);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		customerDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		int result = customerDao.insertSelective(customer);
		if (1 == result) {
			return true;
		} else {
			return false;
		}
	}



}
