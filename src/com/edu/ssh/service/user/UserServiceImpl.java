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
	 * ��֤�û���¼ʱ����Ϣ
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#validate(com.edu.ssh.entity.User)
	 */
	@Override
	public User validate(User user) {
		return userDao.validate(user);
	}
	
	/*
	 * (���)�����û���Ϣ
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#save(com.edu.ssh.entity.User)
	 */
	@Override
	public void save(User user) {
		userDao.save(user);
	}
	
	/*
	 * ɾ���û���Ϣ/(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#delete(com.edu.ssh.entity.User)
	 */
	@Override
	public void delete(User user) {
		userDao.delete(user);
	}
	
	/*
	 * 1����ѯ��Ҫ�޸ĵ��û�����Ϣ
	 * 2�������޸��û���Ϣ����ʾ��ҳ����
	 * 3������û��޸�
	 * 4����ʾ�޸���ɺ����Ϣ
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
	 * 1����ȡ��ҳ���û���Ϣ
	 * 2����ȡ�û�������
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
	 * ��ȡ�û���ɫ��Ϣ/(non-Javadoc)
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
	 *1������������������������û�
	 *2��������������û�������
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
