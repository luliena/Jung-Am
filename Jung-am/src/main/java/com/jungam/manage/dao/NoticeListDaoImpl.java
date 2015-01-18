package com.jungam.manage.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jungam.manage.vo.NoticeListVO;

@Repository("noticelistDao")		//define noticelist as NoticeListDaoImple
public class NoticeListDaoImpl extends SqlMapClientDaoSupport implements NoticeListDao {
	
	@Autowired
	public NoticeListDaoImpl(SqlMapClient sqlMapClient){
		super();
		setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<NoticeListVO> getNoticeList() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<NoticeListVO>) getSqlMapClientTemplate().queryForList("notice.list");
	}

	@Override
	public NoticeListVO getNotice(int index) throws Exception {
		return (NoticeListVO) getSqlMapClientTemplate().queryForObject("notice.getnotice", index);
	}
}
