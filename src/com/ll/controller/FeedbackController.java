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
import com.ll.pojo.Feedback;
import com.ll.pojo.Feedback;
import com.ll.service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

	private static final Log logger = LogFactory.getLog(FeedbackController.class);
	@Autowired
	public FeedbackService feedbackService;

	/*
	 * 查询
	 */
	 @RequestMapping("/find")
	 public String findFeedback(@Param("cid") Integer cid, HttpSession session, Model model){
		Feedback findFeedback = feedbackService.findFeedbackByCid(cid);  //根据aitem获取用户详情
		//建立session，处理删除操作是方便传值
		session.setAttribute("feedback", findFeedback);
    	model.addAttribute("findFeedback", findFeedback);
    	logger.info("【操作】：根据cid查询用户详情...");
    	return "feedbackFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Feedback feedback, HttpSession session, Model model) {
		 Feedback feedback2 = (Feedback) session.getAttribute("feedback");
		 feedbackService.deleteByPrimaryKey(feedback2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	 /**
	 * 添加新服务
	 */
	@RequestMapping(value="/profile")
	public String profile(@ModelAttribute("feedback") Feedback feedback) {
		if (feedbackService.addFeedback(feedback)) {
			logger.info("成功");
			return "main";// 注册成功，跳转到login.jsp
		} else {
			logger.info("失败");
			// 使用@ModelAttribute("feedback")与model.addAttribute("feedback", feedback)功能相同
			// 在register.jsp页面上可以使用EL表达式${feedback.uname}取出ModelAttribute的uname值
			return "feedbackProfile";// 返回register.jsp
		}
	}

	
	@RequestMapping(value = "/list")
	public String listFeedbacks(Model model) {
		List<Feedback> feedbacks = feedbackService.getFeedbacks();
		model.addAttribute("feedbacks", feedbacks);
		return "feedbackList";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model) {
		return "main";
	}
}
