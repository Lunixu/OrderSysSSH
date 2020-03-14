package com.edu.ssh.service.order;

import java.util.List;

import com.edu.ssh.dao.order.IOrderDao;
import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderContent;
import com.edu.ssh.entity.OrderState;

public class OrderServiceImpl implements IOrderService {

	private IOrderDao orderDao;

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	public void delete(Order order) {
		orderDao.delete(order);
	}

	@Override
	public Order getById(int id) {

		return orderDao.getById(id);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orderDao.getOrders();
	}

	@Override
	public void update(Order order) {
		orderDao.update(order);
	}

	@Override
	public OrderState getOrderStateById(int id) {
		return orderDao.getOrderStateById(id);
	}

	@Override
	public List<Order> getOrdersByStateId(Integer stateId) {
		return orderDao.getOrdersByStateId(stateId);
	}

	/*@Override
	public OrderContent getContentById(int id) {
		return orderDao.getContentById(id);
	}*/

}
