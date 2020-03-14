package com.edu.ssh.action.waiter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.Dish;
import com.edu.ssh.entity.Order;
import com.edu.ssh.entity.OrderContent;
import com.edu.ssh.entity.Table;
import com.edu.ssh.service.dish.IDishService;
import com.edu.ssh.service.order.IOrderService;
import com.edu.ssh.service.table.ITableService;
import com.google.gson.Gson;

public class WaiterAction{
	
	private IDishService dishService;
	private ITableService tableService;
	private IOrderService orderService;
	private Integer currentPage4;
	// 接受Order参数
	private Integer tableId;
	private Integer waiterId;
	private Integer stateId;
	private Integer[] dishId;
	private Integer[] dishNumber;
	private Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public IOrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}
	public Integer getCurrentPage4() {
		return currentPage4;
	}
	public void setCurrentPage4(Integer currentPage4) {
		this.currentPage4 = currentPage4;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public Integer getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer[] getDishId() {
		return dishId;
	}
	public void setDishId(Integer[] dishId) {
		this.dishId = dishId;
	}
	public Integer[] getDishNumber() {
		return dishNumber;
	}
	public void setDishNumber(Integer[] dishNumber) {
		this.dishNumber = dishNumber;
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
	/*
	 *得到空闲的餐桌并返回给前端jsp
	 */
	public String test(){
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Table> wtables=tableService.getTablesisFree();
		Gson gson=new Gson();
		String gsontables=gson.toJson(wtables);
		try {
			ServletActionContext.getResponse().getWriter().print(gsontables);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 *获得所有的菜品信息
	 */
	public String list() {
		List<Dish> dishes=dishService.getDishes();
		ServletActionContext.getContext().getSession().put("wdishes", dishes);
		List<Table> wtables=tableService.getTablesisFree();
		ServletActionContext.getContext().getSession().put("wtables", wtables);
		return "list";
	}
	
	/*
	 *用户支付订单
	 */
	public String showorders() {
		List<Order> orders = orderService.getOrders();
		ServletActionContext.getContext().getSession().put("orders", orders);
		return "showorders";
	}
	
	/*
	 *下单
	 */
	public String orderok() {
		Order order = new Order();
		order.setBeginTime(new Date());
		order.setState(orderService.getOrderStateById(stateId));
		order.setWaiterId(waiterId);
		order.setTableId(tableId);
		System.out.println(stateId+"|||"+waiterId+"|||"+tableId);
		Set<OrderContent> foods=new HashSet<OrderContent>();
		OrderContent food=null;
		for(int i=0;i<dishId.length;i++){
			food=new OrderContent();
			food.setDish(dishService.getById(dishId[i]));
			food.setDishNumber(dishNumber[i]);
			food.setOrder(order);
			foods.add(food);
		}
		order.setFood(foods);
		System.out.println(order);
		orderService.save(order);
		Table table = new Table();
		table.setId(tableId);
		table.setIsFree('否');
		tableService.update(table);
		return "orderok";
	}
	
	/*
	 *展示订单详细信息
	 */
	public String showdetal(){
		Order detalorder = orderService.getById(id);
		Set<OrderContent> orderdishs = detalorder.getFood();
		Double totalAmount = 0.0;
		for (OrderContent dish : orderdishs) {
			Double oneAmount = dish.getDishNumber()*dish.getDish().getPrice();
			totalAmount+=oneAmount;
		}
		ServletActionContext.getContext().getSession().put("totalAmount", totalAmount);
		ServletActionContext.getContext().getSession().put("detalorder", detalorder);
		return "showdetal";
	}
	/*
	 *修改订单信息
	 *1、获取订单信息，显示到修改页面中
	 *2、修改信息并提交
	 */
	public String upd(){
		Order updateorder = orderService.getById(id);
		ServletActionContext.getContext().getSession().put("updateorder", updateorder);
		return "upd";
	}
	public String update(){
		return "";
	}
}
