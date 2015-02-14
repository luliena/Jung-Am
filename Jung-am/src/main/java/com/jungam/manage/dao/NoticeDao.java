package com.jungam.manage.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jungam.manage.vo.BoardVO;

@Repository("noticeDao")
public class NoticeDao extends BoardDao {
	private static final String GET_NOTICE_LIST = "notice.list";
	private static final String GET_FILE_LIST = "notice.filelist";
	private static final String GET_NOTCIE_NODE = "notice.getnotice";
	private static final String ADD_NOTICE_NODE = "notice.addnotice";
	private static final String ADD_FILE_NODE = "notice.addfile";
	
	@Autowired
	public NoticeDao(SqlMapClient sqlMapClient){
		super(sqlMapClient);
	}

	@SuppressWarnings("rawtypes")
	public HashMap getNoticeList(int offset, int limit) throws Exception {
		return super.getBoardList(GET_NOTICE_LIST, GET_FILE_LIST, offset, limit);
	}

	public BoardVO getNoticeNode(int index) throws Exception {
		return super.getBoardNode(GET_NOTCIE_NODE, index);
	}
	
	public void addBoardNode(BoardVO board) {
		super.addBoardNode(ADD_NOTICE_NODE, ADD_FILE_NODE, board);
	}
}
