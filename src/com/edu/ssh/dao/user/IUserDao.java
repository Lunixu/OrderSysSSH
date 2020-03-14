package com.edu.ssh.dao.user;

import java.util.List;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public interface IUserDao {
	
	//登录验证用户信息
	User validate(User user);
	//保存用户信息
	void save(User user);
	//int validate(User user);
	//删除用户
	void delete(User user);
	//修改用户信息
	User getOneUserToUpdate(Integer id);//获取需要修改的用户信息
	void update(User user);
	//分页显示用户信息
	List<User> getUserByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//获取系统角色信息
	List<UserPosition> getAllPosition();
	UserPosition getPositionById(int id);
	//根据条件查找用户
	public Long getCountByKey(String keyword);
	public List<User> getUsersByKey(String keyword);
}
