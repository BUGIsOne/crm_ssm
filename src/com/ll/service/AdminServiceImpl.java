package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.AdminMapper;
import com.ll.pojo.Admin;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapper adminDao;
	@Override
	public Admin login(Admin admin) {
		Admin founded = adminDao.findByAdminAndPass(admin);
		return founded;
	}
	@Override
	public boolean register(Admin admin) {
		int result = adminDao.insertSelective(admin);
		if (1 == result) {
			//生成AdminExt记录
			/* AdminExt ext = new AdminExt(); */
			/* ext.setId(admin.getUid()); */
			/* adminExtDao.insertSelective(ext); */
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void updateAdmin(Admin admin) {
		/* adminExtDao.updateByPrimaryKeySelective(admin.getExt()); */
		adminDao.updateByPrimaryKeySelective(admin);
	}
	
	
	

	/*
	 * @Autowired private AdminExtMapper adminExtDao;
	 */
	@Override
	public List<Admin> getAdmins() {
		List<Admin> list = adminDao.selectAllAdmin();
		return list;
	}
	@Override
	public Admin findAdminById(Integer uid) {
		// TODO Auto-generated method stub
		return adminDao.selectByPrimaryKey(uid);
	}
	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		adminDao.deleteByPrimaryKey(id);
	}
	@Override
	public Admin findAdminByAname(String aname) {
		// TODO Auto-generated method stub
		return adminDao.selectByAname(aname);
	}

}
