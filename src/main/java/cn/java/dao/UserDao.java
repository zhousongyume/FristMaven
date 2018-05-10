package cn.java.dao;

import java.util.List;

import cn.java.entity.User;

public interface UserDao {
		/**
		 * 查询用户信息
		 */
	
	public List<User> getUser();
}
