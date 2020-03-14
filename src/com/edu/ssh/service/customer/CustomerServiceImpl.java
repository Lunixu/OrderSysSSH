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
	 *获取所有消费者的信息
	 */
	@Override
	public List<VIPCustomer> getCustomers() {
		return customerDao.getCustomers();
	}
	
	
	/*
	 *分页显示消费者信息 
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
	 * (添加)保存消费者信息
	 */
	@Override
	public void save(VIPCustomer customer) {
		customerDao.save(customer);
	}
	
	
	/*
	 * 删除相对应的消费者
	 */
	@Override
	public void delete(VIPCustomer customer) {
		customerDao.delete(customer);
	}
	
	
	/*
	 *修改消费者信息
	 *1、获取需要修改消费者的信息，显示到修改页面
	 *2、完成修改
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
	 * 按要求查询消费者信息，
	 * 返回数据和满足条件的数据条数
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
