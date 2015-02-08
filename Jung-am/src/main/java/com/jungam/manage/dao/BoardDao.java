package com.jungam.manage.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jungam.manage.vo.BoardVO;

public class BoardDao extends SqlMapClientDaoSupport{
	private final static Logger logger = Logger.getLogger(BoardDao.class);

	@Autowired
	public BoardDao(SqlMapClient sqlMapClient){
		super();
		setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("rawtypes")
	protected HashMap getBoardList(String sql, int offset, int limit)
			throws Exception {
		HashMap<Integer, BoardVO> map = new HashMap<Integer, BoardVO>();
		
		BoardVO board = new BoardVO();
		board.setOffset(offset);
		board.setLimit(limit);
		
		@SuppressWarnings("unchecked")
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) getSqlMapClientTemplate().queryForList("notice.list", board);
		
		for(BoardVO n : list) {
			map.put(n.getIndex(), n);
			logger.debug("List Index : " + n.getIndex());
			logger.debug("List Title : " + n.getTitle());
			logger.debug("List Writer : " + n.getWriter());
			logger.debug("List Context : " + n.getContent());
			logger.debug("List HitCount : " + n.getHitCount());
		}
		
		return map;
	}

	protected BoardVO getBoardNode(String sql, int index) throws Exception {
		return  (BoardVO) getSqlMapClientTemplate().queryForObject(sql, index);
	}
	
	protected void addBoardNode(String sql, BoardVO board) {
		logger.debug("Add Title : " + board.getTitle());
		logger.debug("Add Writer : " + board.getWriter());
		logger.debug("Add Context : " + board.getContent());
		
		getSqlMapClientTemplate().delete(sql, board);
	}
	
	/*
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<NoticeListVO> getNoticeList() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<NoticeListVO>) getSqlMapClientTemplate().queryForList("notice.list");
	}*/
}
