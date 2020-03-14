package com.edu.ssh.dao.user;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;

public class UserDaoImpl implements IUserDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 * ��֤�û���¼ʱ����Ϣ
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#validate(com.edu.ssh.entity.User)
	 */
	@Override
	public User validate(User user) {
		String hql = "select DISTINCT u from User u inner join fetch u.position where acount=?";
		User dbuser = (User)sessionFactory.getCurrentSession()
						.createQuery(hql).setString(0, user.getAcount()).uniqueResult();
		System.out.println(dbuser);
		if(dbuser == null)
			return null;
			//return -1;
		if(dbuser.getPwd().equals(user.getPwd()))
			return dbuser;
			//return dbuser.getPosition().getId();
		return null;
		//return -1;
	}

	/*
	 * (���)�����û���Ϣ
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#save(com.edu.ssh.entity.User)
	 */
	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	/*
	 * ɾ���û���Ϣ/(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#delete(com.edu.ssh.entity.User)
	 */
	@Override
	public void delete(User user) {
		//��Ҫ�ȼ��أ���ɾ�����ȼ�����Ϊ�˵õ��־û���User,��User��session����
		//���Խ��м�������������ֱ��ɾ�������е�user����user����session�������ܽ��м�������
		User myuser=(User) sessionFactory.getCurrentSession().get(User.class, user.getId());
		sessionFactory.getCurrentSession().delete(myuser);
	}
	
	/*
	 * 1����ѯ��Ҫ�޸ĵ��û�����Ϣ
	 * 2�������޸��û���Ϣ����ʾ��ҳ����
	 * 3������û��޸�
	 * 4����ʾ�޸���ɺ����Ϣ
	 */
	@Override
	public User getOneUserToUpdate(Integer id) {
		String hql = "select distinct u from User u inner join fetch u.position where u.id=?";
		return (User)sessionFactory.getCurrentSession()
				.createQuery(hql).setInteger(0, id).uniqueResult();
	}
	@Override
	public void update(User user) {
		User myuser = (User)sessionFactory.getCurrentSession().get(User.class, user.getId());
		myuser.setAcount(user.getAcount());
		myuser.setAddress(user.getAddress());
		myuser.setFaceImg(user.getFaceImg());
		myuser.setName(user.getName());
		myuser.setPhoneNumber(user.getPhoneNumber());
		myuser.setPosition(user.getPosition());
		myuser.setPwd(user.getPwd());
		sessionFactory.getCurrentSession().update(myuser);
	}
	/*
	 * 1����ȡ��ҳ���û���Ϣ
	 * 2����ȡ�û�������
	 * /(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#getUserByPage(int, int)
	 */
	@Override
	public List<User> getUserByPage(int pageNum, int pageSize) {
		String hql = "select distinct u from User u inner join fetch u.position order by u.id asc";
		List<User> users = sessionFactory.getCurrentSession()
				.createQuery(hql).setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize).list();
		return users;
	}
	@Override
	public int getPageCount(int pageSize) {
		String hql = "select count(*) from User";
		Long count = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)((count+pageSize-1)/pageSize);
	}
	
	/*
	 * ��ȡ�û���ɫ��Ϣ/(non-Javadoc)
	 * @see com.edu.ssh.service.user.IUserService#getAllPosition()
	 */
	@Override
	public List<UserPosition> getAllPosition() {
		String hql = "from UserPosition";
		List<UserPosition> position = sessionFactory.getCurrentSession()
				.createQuery(hql).list();
		return position;
	}
	@Override
	public UserPosition getPositionById(int id) {
		UserPosition position = (UserPosition)sessionFactory
				.getCurrentSession().get(UserPosition.class,id);
		return position;
	}
	
	/*
	 *1������������������������û�
	 *2��������������û�������
	 */
	@Override
	public Long getCountByKey(String keyword) {
		String hql="select count(*) from User where name like ?";
		Long count=(Long) sessionFactory.getCurrentSession().createQuery(hql)
						.setString(0, "%"+keyword+"%").uniqueResult();
		return count;
	}
	@Override
	public List<User> getUsersByKey(String keyword) {
		String hql="from User u inner join fetch u.position where u.name like ?";
		List<User> users = sessionFactory.getCurrentSession().createQuery(hql)
								.setString(0, "%"+keyword+"%").list();
		return users;
	}
}
