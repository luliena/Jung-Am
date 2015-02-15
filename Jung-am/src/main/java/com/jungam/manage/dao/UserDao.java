package com.jungam.manage.dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.jungam.manage.vo.UserVO;

@Repository("userDao")
public class UserDao extends SqlMapClientDaoSupport{
	private final static Logger logger = Logger.getLogger(UserDao.class);
	
	private final static String GET_LIST = "users.list";
	private final static String GET_USER = "users.gerUser";
	private final static String ADD_USER = "users.addUser";
	private final static String DELETE_USER = "users.deleteUser";
	private final static String UPDATE_USER = "users.updateUser";

	@Autowired
	public UserDao(SqlMapClient sqlMapClient) {
		super();
		setSqlMapClient(sqlMapClient);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<UserVO> list() {
		ArrayList<UserVO> users = (ArrayList<UserVO>) getSqlMapClientTemplate().queryForList(GET_LIST);
		
		if(users == null) return new ArrayList<UserVO>();
		
		for(UserVO user : users) {
			logger.trace(traceUserInfo(user));
		}
		return users;
	}
	
	public UserVO getUser(String id) {
		UserVO user = (UserVO) getSqlMapClientTemplate().queryForObject(GET_USER, id);
		
		if(user == null) return null;
		
		logger.trace(traceUserInfo(user));
		
		return user; 
	}
	
	public void addUser(UserVO user) {
		getSqlMapClientTemplate().insert(ADD_USER, user);
	}
	
	public void deleteUser(String user) {
		getSqlMapClientTemplate().delete(DELETE_USER, user);
	}
	
	public void updateUser(UserVO user) {
		getSqlMapClientTemplate().update(UPDATE_USER, user);
	}
	
	private String traceUserInfo(UserVO user) {
		StringBuilder sb = new StringBuilder();
		sb.append("id : " + user.getId());
		sb.append(", password : " + user.getPassword());
		sb.append(", name : " + user.getName());
		sb.append(", e-mail : " + user.getEmail());
		sb.append(", phone : " + user.getPhone());
		sb.append(", lastDate : " + user.getLastDate());
		
		return sb.toString();
	}
}
