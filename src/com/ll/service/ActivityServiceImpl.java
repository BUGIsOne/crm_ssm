package com.ll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ll.dao.ActivityMapper;
import com.ll.pojo.Activity;

@Service
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private ActivityMapper activityDao;
	@Override
	public void updateactivity(Activity activity) {
		// TODO Auto-generated method stub
		activityDao.updateByPrimaryKeySelective(activity);
	}

	@Override
	public List<Activity> getActivitys() {
		// TODO Auto-generated method stub
		List<Activity> list = activityDao.selectAllActivity();
		return list;
	}


	@Override
	public Activity findCustomer(Activity activity) {
		// TODO Auto-generated method stub
		return activityDao.findByUidAndCus(activity);
	}

	@Override
	public Activity findActivityByAitem(String aitem) {
		// TODO Auto-generated method stub
		return activityDao.selectByAitem(aitem);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		activityDao.deleteByPrimaryKey(id);
	}

	@Override
	public boolean addActivity(Activity activity) {
		// TODO Auto-generated method stub
		int result = activityDao.insertSelective(activity);
		if (1 == result) {
			return true;
		} else {
			return false;
		}
	}

}
