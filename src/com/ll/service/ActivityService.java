package com.ll.service;

import java.util.List;

import com.ll.pojo.Activity;
import com.ll.pojo.Admin;

public interface ActivityService {

	void updateactivity(Activity activity);
	List<Activity> getActivitys();
	Activity findCustomer(Activity activity);
	Activity findActivityByAitem(String aitem);
	void deleteByPrimaryKey(Integer id);
	//添加新活动
	boolean addActivity(Activity activity);
}
