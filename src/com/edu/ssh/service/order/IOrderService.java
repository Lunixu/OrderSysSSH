package com.edu.ssh.service.order;

import java.util.List;

import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderContent;
import com.edu.ssh.entity.OrderState;

public interface IOrderService {
	
	//���涩��
	void save(Order order);
	//ɾ������
	void delete(Order order);
	//����ID��ѯ����
	Order getById(int id);
	/*//����ID��ѯ��������
	OrderContent getContentById(int id);*/
	//��ȡ���еĶ���
	List<Order> getOrders();
	//�����޸�
	void update(Order order);
	//�õ�����״̬
	OrderState getOrderStateById(int id);
	//����״̬ID��ȡ����������order
	List<Order> getOrdersByStateId(Integer stateId);

}
