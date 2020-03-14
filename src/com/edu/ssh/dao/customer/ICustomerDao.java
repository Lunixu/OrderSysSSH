package com.edu.ssh.dao.customer;

import java.util.List;

import com.edu.ssh.entity.VIPCustomer;

public interface ICustomerDao {
	
	//������������Ϣ
	void save(VIPCustomer customer);
	//��ȡ������������Ϣ
	List<VIPCustomer> getCustomers();
	//��ҳ��ʾ��������Ϣ
	List<VIPCustomer> getCustomerByPage(int pageNum, int pageSize);
	int getPageCount(int pageSize);
	//ɾ�����Ӧ������������
	void delete(VIPCustomer customer);
	//�޸���������Ϣ
	VIPCustomer getOneCustomerToUpdate(Integer id);//��ȡ��Ҫ�޸ĵ��û���Ϣ
	void update(VIPCustomer customer);
	//��Ҫ���ѯ��Ӧ����������
	List<VIPCustomer> getCustomerByKey(String keyword);
	Long getCountCustomerByKey(String keyword);

}
