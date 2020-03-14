package com.edu.ssh.service.user;

import java.util.List;

import com.edu.ssh.dao.user.IUserDao;
import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public class UserServiceImpl implements IUserService {

	private IUserDao userDao;
	
	public IUserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	
	/*
	 * 验证用户登录时的信息
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#validate(com.edu.ssh.entity.User)
	 */
	@Override
	public User validate(User user) {
		return userDao.validate(user);
	}
	
	/*
	 * (添加)保存用户信息
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#save(com.edu.ssh.entity.User)
	 */
	@Override
	public void save(User user) {
		userDao.save(user);
	}
	
	/*
	 * 删除用户信息/(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#delete(com.edu.ssh.entity.User)
	 */
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	
	/*
	 * 1、查询需要修改的用户的信息
	 * 2、返回修改用户信息，显示到页面中
	 * 3、完成用户修改
	 * 4、显示修改完成后的信息
	 */
	@Override
	public User getOneUserToUpdate(Integer id) {
		return userDao.getOneUserToUpdate(id);
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	
	/*
	 * 1、获取分页的用户信息
	 * 2、获取用户总条数
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#getUserByPage(int, int)
	 */
	@Override
	public List<User> getUserByPage(int pageNum, int pageSize) {
		return userDao.getUserByPage(pageNum, pageSize);
	}
	@Override
	public int getPageCount(int pageSize) {	
		return userDao.getPageCount(pageSize);
	}
	
	/*
	 * 获取用户角色信息/(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#getAllPosition()
	 */
	@Override
	public List<UserPosition> getAllPosition() {
		return userDao.getAllPosition();
	}
	@Override
	public UserPosition getPositionById(int id) {
		return userDao.getPositionById(id);
	}
	
	/*
	 *1、根据条件获得满足条件的用户
	 *2、获得满足条件用户的条数
	 */
	@Override
	public Long getCountByKey(String keyword) {
		return userDao.getCountByKey(keyword);
	}
	@Override
	public List<User> getUsersByKey(String keyword) {
		return userDao.getUsersByKey(keyword);
	}
}
