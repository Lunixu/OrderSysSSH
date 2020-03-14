package com.edu.ssh.dao.customer;

import java.util.List;

import com.edu.ssh.entity.VIPCustomer;

public interface ICustomerDao {
	
	//保存消费者信息
	void save(VIPCustomer customer);
	//获取所有消费者信息
	List<VIPCustomer> getCustomers();
	//分页显示消费者信息
	List<VIPCustomer> getCustomerByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//删除相对应的消费者数据
	void delete(VIPCustomer customer);
	//修改消费者信息
	VIPCustomer getOneCustomerToUpdate(Integer id);//获取需要修改的用户信息
	void update(VIPCustomer customer);
	//按要求查询相应消费者数据
	List<VIPCustomer> getCustomerByKey(String keyword);
	Long getCountCustomerByKey(String keyword);

}
