package com.devjjo.cafeteria.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.devjjo.cafeteria.dao.Cafeteria_Rest_Dao;
import com.devjjo.cafeteria.model.User;;

@Repository
public class Cafeteria_Rest_DaoImpl implements Cafeteria_Rest_Dao{

	@Inject
	private SqlSession session;
	
	public List<User> selectUser() {
		// TODO Auto-generated method stub
		List<User> UserList = new ArrayList<User>();
		UserList = session.selectList("CafeteriaSqlMap.selectUser");
		return UserList;
	}

	@Override
	public User selectUserOne(Map<String, Object> param) {
		// TODO Auto-generated method stub
		User user = new User();
		user = session.selectOne("CafeteriaSqlMap.selectUserOne", param);
		return user;
	}

	@Override
	public int insertUser(User user) {
		return session.insert("CafeteriaSqlMap.insertUser", user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return session.update("CafeteriaSqlMap.updateUser", user);
	}

	@Override
	public int delete_user(Map<String, Object> param) {
		// TODO Auto-generated method stub
		return session.delete("CafeteriaSqlMap.delete_user", param);
	}



}

