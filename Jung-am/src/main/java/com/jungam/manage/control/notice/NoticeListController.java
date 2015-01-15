package com.jungam.manage.control.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jungam.manage.dao.NoticeListDao;
import com.jungam.manage.vo.NoticeListVO;


@Controller
public class NoticeListController {
	//private static final Logger logger =
	
	@Autowired
	@Qualifier("noticelist")		// define of noticeListDao
	private NoticeListDao noticeListDao;
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)	// get request from '/notice' page
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse res)	throws Exception {
		// TODO Auto-generated method stub
		System.out.println("++++++++++ start noticeList");
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("++++++++++ get noticeList");
		ArrayList<NoticeListVO> noticeListVo = (ArrayList<NoticeListVO>) noticeListDao.getNoticeList();
		
		mv.setViewName("noticeList");		// set jsp view name
		mv.addObject("list", noticeListVo);	// set paramater and send object to jsp view
		
		for(int i=0; i<noticeListVo.size(); i++)		//test
			System.out.println("========== " + noticeListVo.get(i).getTitle());
		
		System.out.println("++++++++++ print noticeList");
		
		return mv;
	}
}
