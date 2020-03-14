package com.edu.ssh.dao.customer;

import java.util.List;

import org.hibernate.SessionFactory;
import com.edu.ssh.entity.VIPCustomer;

public class CustomerDaoImpl implements ICustomerDao{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 *获取所有消费者的信息
	 */
	@Override
	public List<VIPCustomer> getCustomers() {
		String hql = "from VIPCustomer";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).list();
	}
	
	
	/*
	 *分页显示消费者信息 
	 */
	@Override
	public List<VIPCustomer> getCustomerByPage(int pageNum, int pageSize) {
		String hql = "from VIPCustomer";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).setFirstResult((pageNum-1)*pageSize)
				.setMaxResults(pageSize).list();
	}
	@Override
	public int getPageCount(int pageSize) {
		String hql = "select count(*) from VIPCustomer";
		Long count = (Long)sessionFactory.getCurrentSession()
				.createQuery(hql).uniqueResult();
		return (int)((count+pageSize-1)/pageSize);
	}
	
	
	/*
	 * (添加)保存消费者信息
	 */
	@Override
	public void save(VIPCustomer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}
	
	
	/*删除消费者信息
	 */
	@Override
	public void delete(VIPCustomer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}
	
	
	/*
	 *修改消费者信息
	 *1、获取需要修改消费者的信息，显示到修改页面
	 *2、完成修改
	 */
	@Override
	public VIPCustomer getOneCustomerToUpdate(Integer id) {
		String hql = "from VIPCustomer where id=?";
		return (VIPCustomer)sessionFactory.getCurrentSession()
				.createQuery(hql).setInteger(0, id).uniqueResult();
	}
	@Override
	public void update(VIPCustomer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}
	
	
	/*
	 * 按要求查询消费者信息，
	 * 返回数据和满足条件的数据条数
	 */
	@Override
	public List<VIPCustomer> getCustomerByKey(String keyword) {
		String hql = "from VIPCustomer where name like ?";
		List<VIPCustomer> customers = sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").list();
		return customers;
	}
	@Override
	public Long getCountCustomerByKey(String keyword) {
		String hql = "select count(*) from VIPCustomer where name like ?";
		Long customerCountByKey=(Long) sessionFactory.getCurrentSession()
				.createQuery(hql).setString(0, "%"+keyword+"%").uniqueResult();
		return customerCountByKey;
	}

}
