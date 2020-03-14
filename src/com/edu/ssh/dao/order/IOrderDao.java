package com.edu.ssh.dao.order;

import java.util.List;

import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderContent;
import com.edu.ssh.entity.OrderState;

public interface IOrderDao {
	
	//保存订单
	void save(Order order);
	//删除订单
	void delete(Order order);
	//根据ID查询订单
	Order getById(int id);
	/*//根据ID查询订单详情
	OrderContent getContentById(int id);*/
	//获取所有的订单
	List<Order> getOrders();
	//订单修改
	void update(Order order);
	//得到订单状态
	OrderState getOrderStateById(int id);
	//根据状态ID获取满足条件的order
	List<Order> getOrdersByStateId(Integer stateId);

}
