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
	 public String findFeedback(@Param("cid") Integer cid, Model model){
		Feedback findFeedback = feedbackService.findFeedbackByCid(cid);  //根据aitem获取用户详情
    	model.addAttribute("findFeedback", findFeedback);
    	logger.info("【操作】：根据cid查询用户详情...");
    	return "feedbackFind";
    }
	 /*
	  * 删除
	  */
	 @RequestMapping("/delete")
	 public String delete(Feedback feedback, HttpSession session, Model model) {
		 Feedback feedback2 = (Feedback) session.getAttribute("u");
		 feedbackService.deleteByPrimaryKey(feedback2.getId());
		 logger.info("删除成功");
		 return "main";
	}
	
	
	/**
	 * 保存服务信息资料
	 */
	@RequestMapping(value="/profile",method=RequestMethod.POST)
	public String saveProfile(@ModelAttribute("feedback") Feedback feedback) {
		feedbackService.updateFeedback(feedback);
		logger.info("更新成功");
		return "main";// 注册成功，跳转到login.jsp
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
