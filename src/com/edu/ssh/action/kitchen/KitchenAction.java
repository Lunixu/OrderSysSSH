package com.edu.ssh.action.kitchen;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.Order;
import com.edu.ssh.service.dish.IDishService;
import com.edu.ssh.service.order.IOrderService;
import com.edu.ssh.service.table.ITableService;

public class KitchenAction {
	
	private IDishService dishService;
	private ITableService tableService;
	private IOrderService orderService;
	
	private Integer dishid;
	
	
	
	
	public Integer getDishid() {
		return dishid;
	}
	public void setDishid(Integer dishid) {
		this.dishid = dishid;
	}
	public IDishService getDishService() {
		return dishService;
	}
	public void setDishService(IDishService dishService) {
		this.dishService = dishService;
	}
	public ITableService getTableService() {
		return tableService;
	}
	public void setTableService(ITableService tableService) {
		this.tableService = tableService;
	}
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	
	public String list(){
		List<Order> ordersByStateId = orderService.getOrdersByStateId(3);
		ordersByStateId.addAll(orderService.getOrdersByStateId(4));
		ServletActionContext.getContext().getSession().put("ordersByStateId", ordersByStateId);
		return "list";
	}
	
	public String delDish(){
		return "";
	}

}
