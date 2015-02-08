package com.jungam.manage.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jungam.manage.vo.BoardVO;
import com.jungam.manage.vo.FileVO;

public class BoardDao extends SqlMapClientDaoSupport{
	private final static Logger logger = Logger.getLogger(BoardDao.class);

	@Autowired
	public BoardDao(SqlMapClient sqlMapClient){
		super();
		setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected HashMap getBoardList(String sql, String fileSql, int offset, int limit)
			throws Exception {
		HashMap<Integer, BoardVO> map = new HashMap<Integer, BoardVO>();
		
		BoardVO board = new BoardVO();
		board.setOffset(offset);
		board.setLimit(limit);
		
		ArrayList<BoardVO> list = (ArrayList<BoardVO>) getSqlMapClientTemplate().queryForList(sql, board);
		
		for(BoardVO n : list) {
			n.setFiles((ArrayList<FileVO>) getSqlMapClientTemplate().queryForList(fileSql, n.getIndex()));
			
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
	
	protected void addBoardNode(String boardSql, String indexSql, String fileSql, BoardVO board) {
		logger.debug("Add Title : " + board.getTitle());
		logger.debug("Add Writer : " + board.getWriter());
		logger.debug("Add Context : " + board.getContent());
		
		getSqlMapClientTemplate().insert(boardSql, board);
		
		BoardVO index = (BoardVO) getSqlMapClientTemplate().queryForObject(indexSql, board);
		
		
	}
	
	
}
