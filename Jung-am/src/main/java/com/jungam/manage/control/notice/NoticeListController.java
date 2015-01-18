package com.jungam.manage.control.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jungam.manage.dao.NoticeListDao;
import com.jungam.manage.vo.NoticeListVO;


@Controller
public class NoticeListController {

	private final static Logger logger = Logger.getLogger(NoticeListController.class);
	
	@Autowired
	@Qualifier("noticelistDao")		// define of noticeListDao
	private NoticeListDao noticeListDao;
	
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)	// get request from '/notice' page
	protected ModelAndView noticeList(HttpServletRequest req, HttpServletResponse res)	throws Exception {
		// TODO Auto-generated method stub
		System.out.println("++++++++++ start noticeList");
		
		logger.debug("noticeList");
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("++++++++++ get noticeList");
		ArrayList<NoticeListVO> noticeListVo = (ArrayList<NoticeListVO>) noticeListDao.getNoticeList();
		
		mv.setViewName("notices/noticeList");		// set jsp view name
		mv.addObject("list", noticeListVo);	// set paramater and send object to jsp view
		
		for(int i=0; i<noticeListVo.size(); i++)		//test
			System.out.println("========== " + noticeListVo.get(i).getTitle());
		
		System.out.println("++++++++++ print noticeList");
		
		return mv;
	}
	
	@RequestMapping(value = "/notice/{index}", method = RequestMethod.GET)	// get request from '/notice' page
	protected ModelAndView showNotice(HttpServletRequest req, HttpServletResponse res, @PathVariable int index)	throws Exception {
		// TODO Auto-generated method stub
		System.out.println("++++++++++ start notice");
		
		logger.debug("show notice");
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("++++++++++ get notice : " + index);
		NoticeListVO noticeListVo = (NoticeListVO) noticeListDao.getNotice(index);
		
		mv.setViewName("notices/showNotice");		// set jsp view name
		mv.addObject("notice", noticeListVo);	// set paramater and send object to jsp view
		
		System.out.println("========== " + noticeListVo.getTitle());
		
		System.out.println("++++++++++ print notice");
		
		return mv;
	}
}
