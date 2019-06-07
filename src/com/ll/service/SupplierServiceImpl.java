package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.SupplierMapper;
import com.ll.pojo.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	private SupplierMapper supplierDao;
	@Override
	public void updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		supplierDao.updateByPrimaryKeySelective(supplier);
	}

	@Override
	public List<Supplier> getSuppliers() {
		List<Supplier> list = supplierDao.selectAllSupplier();
		return list;
	}

	@Override
	public Supplier findSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDao.findBySnumAndSname(supplier);
	}

	@Override
	public Supplier findSupplierBySname(String sname) {
		// TODO Auto-generated method stub
		return supplierDao.selectBySname(sname);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		supplierDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		int result = supplierDao.insertSelective(supplier);
		if (1 == result) {
			return true;
		} else {
			return false;
		}
	}

}
