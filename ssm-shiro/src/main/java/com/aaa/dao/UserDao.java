package com.aaa.dao;

import com.aaa.entity.User;

import java.util.List;
import java.util.Map;

/**
 * className:UserDao
 * discriptoin:
 * author:毛宇
 * createTime:2018-11-15 21:59
 */

public interface UserDao {

	/**
	 * 获取登录时人的用户名
	 * @param user
	 * @return
	 */
	User login(User user);

	/**
	 * 根据username查询角色
	 * @param username
	 * @return
	 */
	List<String> selectRole(String username);

	/**
	 * 根据username查出来权限
	 * @param username
	 * @return
	 */
	List<String> selectPermission(String username);
}

