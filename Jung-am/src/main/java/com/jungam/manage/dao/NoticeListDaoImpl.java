package com.jungam.manage.dao;

import java.util.ArrayList;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jungam.manage.vo.NoticeListVO;

@Repository("noticelist")		//define noticelist as NoticeListDaoImple
public class NoticeListDaoImpl extends SqlMapClientDaoSupport implements NoticeListDao {

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<NoticeListVO> getNoticeList() throws Exception {
		// TODO Auto-generated method stub
		return (ArrayList<NoticeListVO>) getSqlMapClientTemplate().queryForList("notice.list");
	}
}
