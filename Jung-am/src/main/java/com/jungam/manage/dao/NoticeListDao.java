package com.jungam.manage.dao;

import java.util.List;

import com.jungam.manage.vo.NoticeListVO;

public interface NoticeListDao {
	List<NoticeListVO> getNoticeList() throws Exception;
	NoticeListVO getNotice(int index) throws Exception;
}
