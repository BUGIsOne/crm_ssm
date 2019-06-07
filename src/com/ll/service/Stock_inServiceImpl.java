package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.Stock_inMapper;
import com.ll.pojo.Stock_in;
@Service
public class Stock_inServiceImpl implements Stock_inService{

	@Autowired
	private Stock_inMapper stock_inDao;
	@Override
	public List<Stock_in> getStock_ins() {
		// TODO Auto-generated method stub
		List<Stock_in> list = stock_inDao.selectAllStock_in();
		return list;
	}
}
