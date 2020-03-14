package com.edu.ssh.dao.order;

import java.util.List;

import org.hibernate.SessionFactory;

import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderContent;
import com.edu.ssh.entity.OrderState;

public class OrderDaoImpl implements IOrderDao {

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Order order) {
		sessionFactory.getCurrentSession().save(order);
	}

	@Override
	public void delete(Order order) {
		Order myorder=(Order) sessionFactory.getCurrentSession().get(Order.class, order.getId());
		sessionFactory.getCurrentSession().delete(myorder);
	}

	@Override
	public Order getById(int id) {
		String hql="from Order where id=?";
		Order order = (Order) sessionFactory.getCurrentSession().createQuery(hql)
						.setInteger(0, id).uniqueResult();
		return order;
	}

	@Override
	public List<Order> getOrders() {
		String hql="from Order";
		List<Order> orders=sessionFactory.getCurrentSession().createQuery(hql).list();
		return orders;
	}

	@Override
	public void update(Order order) {
		Order myorder = (Order) sessionFactory.getCurrentSession().get(Order.class, order.getId());
		sessionFactory.getCurrentSession().update(myorder);
	}

	@Override
	public OrderState getOrderStateById(int id) {
		String hql="from OrderState where id=?";
		OrderState state=(OrderState) sessionFactory.getCurrentSession().createQuery(hql).setInteger(0, id).uniqueResult();
		return state;
	}

	@Override
	public List<Order> getOrdersByStateId(Integer stateId) {
		String hql="from Order where stateid=?";
		List<Order> ordersByStateId = sessionFactory.getCurrentSession().createQuery(hql).setInteger(0, stateId).list();
		return ordersByStateId;
	}
}
