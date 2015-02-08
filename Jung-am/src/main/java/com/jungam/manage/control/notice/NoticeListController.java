package com.jungam.manage.control.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.jungam.manage.dao.NoticeDao;
import com.jungam.manage.vo.BoardVO;
import com.jungam.manage.vo.FileVO;


@Controller
public class NoticeListController {

	private final static Logger logger = Logger.getLogger(NoticeListController.class);
	private static String REQ_PAGE = "page";
	private static int PAGING_MAX_NODE = 10;		// maxium node in each page 
	private static String SAVE_FILE_PATH = "D:/workspace/Jung-am/Jung-am/upload_files";
	
	@Autowired
	@Qualifier("noticeDao")		// define of noticeListDao
	private NoticeDao noticeDao;
	private HashMap<Integer, BoardVO> noticeList = new HashMap<Integer, BoardVO>();
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/noticeList", method = RequestMethod.GET)	// get request from '/notice' page
	protected ModelAndView notice(HttpServletRequest req, HttpServletResponse res)	throws Exception {
		int page = 0;
		ModelAndView mv = new ModelAndView();

		// get page number default 0
		page = (req.getParameter(REQ_PAGE) == null ? 0 : Integer.parseInt(req.getParameter(REQ_PAGE)) -1 );
		
		noticeList.putAll(noticeDao.getNoticeList(page*PAGING_MAX_NODE, PAGING_MAX_NODE));
		
		mv.setViewName("notice/notice");		// set jsp view name
		mv.addObject("list", noticeList);			// set paramater and send object to jsp view
		
		return mv;
	}
	
	@RequestMapping(value = "/noticeWrite", method = RequestMethod.GET)
	protected ModelAndView showWriteNotice(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		
		logger.debug("write notice");
		mv.setViewName("notice/AddNotice");
		
		return mv;
	}
	
	@RequestMapping(value = "/noticeAdd", method = {RequestMethod.GET, RequestMethod.POST})
	protected ModelAndView AddNotice(MultipartHttpServletRequest request, HttpServletResponse response)	throws Exception {
		logger.debug("write Add");
		request.setCharacterEncoding("euc-kr");

		String title = request.getParameter("title"); 
		String content = request.getParameter("content"); 
		logger.debug(title);
		logger.debug(content);
		
		String writer = "temp"; 			// get id from session or cooki!!
		BoardVO board = new BoardVO(title, writer, content);
		
		List<MultipartFile> files = request.getFiles("file");
		
		ArrayList<FileVO> saveFiles = new ArrayList<FileVO>();
		if(files.size() > 0) {
			for(MultipartFile file : files) {
				logger.debug("file name : " + file.getName() + " / " + file.getContentType()  + "/" + file.getSize());
				
				fileUpload(file, SAVE_FILE_PATH);
				saveFiles.add(new FileVO(SAVE_FILE_PATH + file.getOriginalFilename(), file.getOriginalFilename(), file.getContentType()));
			}
		}
		board.setFiles(saveFiles);
		
		noticeDao.addBoardNode(board);
		
		return notice((HttpServletRequest)request, response);
	}
	
	private static void fileUpload(MultipartFile fileData, String path) throws IOException {
		String originalFileName = fileData.getOriginalFilename();
		long fileSize = fileData.getSize();
		InputStream is = null;
		OutputStream out = null;
		
		try {
			if (fileSize > 0) {
			is = fileData.getInputStream();
			File realUploadDir = new File(path);
			
			if (!realUploadDir.exists()) {             //경로에 폴더가 존재하지 않으면 생성합니다.
				realUploadDir.mkdirs();
			}
			
			out = new FileOutputStream(path +"/"+ originalFileName);
			FileCopyUtils.copy(is, out);            //InputStream에서 온 파일을 outputStream으로 복사
			}else{
				new IOException("잘못된 파일을 업로드 하셨습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			new IOException("파일 업로드에 실패하였습니다.");
		}finally{
			if(out != null){out.close();}
			if(is != null){is.close();}
		}
	}
		
	@RequestMapping(value = "/notice/{index}", method = RequestMethod.GET)	// get request from '/notice' page
	protected ModelAndView showNotice(HttpServletRequest req, HttpServletResponse res, @PathVariable int index)	throws Exception {
		BoardVO notice = null;
		logger.debug("show notice");
		
		ModelAndView mv = new ModelAndView();
		
		if(noticeList == null || (notice = noticeList.get(index)) == null) {
			notice = noticeDao.getNoticeNode(index);
		}
		
		mv.setViewName("notice/ShowNotice");
		mv.addObject("noticeNode", notice);
		
		return mv;
	}
}
