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
	 *��ȡ���������ߵ���Ϣ
	 */
	@Override
	public List<VIPCustomer> getCustomers() {
		String hql = "from VIPCustomer";
		return sessionFactory.getCurrentSession()
				.createQuery(hql).list();
	}
	
	
	/*
	 *��ҳ��ʾ��������Ϣ 
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
	 * (���)������������Ϣ
	 */
	@Override
	public void save(VIPCustomer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}
	
	
	/*ɾ����������Ϣ
	 */
	@Override
	public void delete(VIPCustomer customer) {
		sessionFactory.getCurrentSession().delete(customer);
	}
	
	
	/*
	 *�޸���������Ϣ
	 *1����ȡ��Ҫ�޸������ߵ���Ϣ����ʾ���޸�ҳ��
	 *2������޸�
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
	 * ��Ҫ���ѯ��������Ϣ��
	 * �������ݺ�������������������
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
