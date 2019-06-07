package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.Stock_outMapper;
import com.ll.pojo.Stock_out;
@Service
public class Stock_outServiceImpl implements Stock_outService{

	@Autowired
	private Stock_outMapper stock_outDao;
	@Override
	public List<Stock_out> getStock_outs() {
		// TODO Auto-generated method stub
		List<Stock_out> list = stock_outDao.selectAllStock_out();
		return list;
	}

}
