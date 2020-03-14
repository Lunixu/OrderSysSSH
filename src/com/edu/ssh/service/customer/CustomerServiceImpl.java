package com.edu.ssh.service.customer;

import java.util.List;

import com.edu.ssh.dao.customer.ICustomerDao;
import com.edu.ssh.entity.VIPCustomer;

public class CustomerServiceImpl implements ICustomerService {

	private ICustomerDao customerDao;

	public ICustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	/*
	 *��ȡ���������ߵ���Ϣ
	 */
	@Override
	public List<VIPCustomer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	
	/*
	 *��ҳ��ʾ��������Ϣ 
	 */
	@Override
	public List<VIPCustomer> getCustomerByPage(int pageNum, int pageSize) {
		return customerDao.getCustomerByPage(pageNum, pageSize);
	}

	@Override
	public int getPageCount(int pageSize) {
		return customerDao.getPageCount(pageSize);
	}
	
	
	/*
	 * (���)������������Ϣ
	 */
	@Override
	public void save(VIPCustomer customer) {
		customerDao.save(customer);
	}
	
	
	/*
	 * ɾ�����Ӧ��������
	 */
	@Override
	public void delete(VIPCustomer customer) {
		customerDao.delete(customer);
	}
	
	
	/*
	 *�޸���������Ϣ
	 *1����ȡ��Ҫ�޸������ߵ���Ϣ����ʾ���޸�ҳ��
	 *2������޸�
	 */
	@Override
	public VIPCustomer getOneCustomerToUpdate(Integer id) {
		return customerDao.getOneCustomerToUpdate(id);
	}

	@Override
	public void update(VIPCustomer customer) {
		customerDao.update(customer);
	}
	
	
	/*
	 * ��Ҫ���ѯ��������Ϣ��
	 * �������ݺ�������������������
	 */
	@Override
	public List<VIPCustomer> getCustomerByKey(String keyword) {
		return customerDao.getCustomerByKey(keyword);
	}

	@Override
	public Long getCountCustomerByKey(String keyword) {
		return customerDao.getCountCustomerByKey(keyword);
	}
	
}
