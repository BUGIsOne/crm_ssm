package com.ll.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ll.pojo.Activity;
import com.ll.pojo.Activity;
import com.ll.pojo.Activity;
import com.ll.service.ActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	private static final Log logger = LogFactory.getLog(ActivityController.class);
	@Autowired
	public ActivityService activityService;
	
	/*
	 * 查询
	 */
	 @RequestMapping("/find")
	 public String findActivity(@Param("aitem") String aitem, Model model){
		Activity findActivity = activityService.findActivityByAitem(aitem);  //根据aitem获取用户详情
    	model.addAttribute("findActivity", findActivity);
    	logger.info("【操作】：根据aitem查询用户详情...");
    	System.out.println();
    	System.out.println(findActivity);
    	return "activityFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Activity activity, HttpSession session, Model model) {
		 Activity activity2 = (Activity) session.getAttribute("u");
		 activityService.deleteByPrimaryKey(activity2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	 /**
	 * 添加新活动
	 */
	@RequestMapping(value="/profile")
	public String profile(@ModelAttribute("activity") Activity activity) {
		if (activityService.addActivity(activity)) {
			logger.info("成功");
			return "main";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("activity")与model.addAttribute("activity", activity)功能相同
			// 在register.jsp页面上可以使用EL表达式${activity.uname}取出ModelAttribute的uname值
			return "activityProfile";// 返回register.jsp
		}
	}
	 
	
	@RequestMapping(value = "/list")
	public String listActivitys(Model model) {
		List<Activity> activitys = activityService.getActivitys();
		model.addAttribute("activitys", activitys);
		return "activityList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
