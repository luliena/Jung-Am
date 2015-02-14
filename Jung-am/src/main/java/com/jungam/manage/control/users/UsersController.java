package com.jungam.manage.control.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.nt.NTEventLogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jungam.manage.control.notice.NoticeListController;
import com.jungam.manage.dao.UserDao;
import com.jungam.manage.vo.UserVO;

@Controller
public class UsersController {
	private final static Logger logger = Logger.getLogger(UsersController.class);
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;
	private UserVO user;
	
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	protected ModelAndView userList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ArrayList<UserVO> users = null;
		
		logger.trace("uesrList");
		
		mv.setViewName("login/list");
		
		if((users = userDao.list()) == null) users = new ArrayList<UserVO>();
		
		mv.addObject("list", users);
		
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	protected ModelAndView login(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView("login/login");
	}
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	protected ModelAndView checkLogin(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("check login");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		logger.trace(id + " - " + password);
		
		user = userDao.getUser(id);
		
		return new ModelAndView(new RedirectView("noticeList.do"));
	}
	
	@RequestMapping(value = "/registerUser", method = RequestMethod.GET)
	protected ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("login/register");
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	protected ModelAndView addUser(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		String id = request.getParameter("id");
		UserVO checkId = userDao.getUser(id);

		mv.setViewName("login/list");
		
//		if(checkId == null)	mv.addObject("list", noticeList);
		
		return mv;
	}
	
	@RequestMapping(value = "/checkDuplId", method = RequestMethod.POST)
	protected void checkDuplicateId(HttpServletRequest request, HttpServletResponse response) {
		boolean duplicateId = true;
		String id = request.getParameter("id");
		UserVO checkId = userDao.getUser(id);

		if(checkId == null) duplicateId = false;
		
		logger.debug("duplicate Id : " + duplicateId);
		
		try {
			PrintWriter writer = response.getWriter();
		} catch (IOException e) {
			logger.error(e);
		}
		
	}
}
