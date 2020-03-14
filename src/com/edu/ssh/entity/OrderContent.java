package com.edu.ssh.entity;

//订单内容数据实体
public class OrderContent {
	private Integer id;// 流水编号
	private Dish dish; // 订单内容中的菜品
	private Integer dishNumber;// 对应菜品的数量
	private Order order;// 订单内容对应订单

	public OrderContent() {
		// TODO Auto-generated constructor stub
	}

	public OrderContent(Dish dish, Integer dishNumber, Order order) {
		this.dish = dish;
		this.dishNumber = dishNumber;
		this.order = order;
	}

	public OrderContent(Integer id, Dish dish, Integer dishNumber, Order order) {
		this.id = id;
		this.dish = dish;
		this.dishNumber = dishNumber;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public Integer getDishNumber() {
		return dishNumber;
	}

	public void setDishNumber(Integer dishNumber) {
		this.dishNumber = dishNumber;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderContent [id=" + id + ", dish=" + dish + ", dishNumber="
				+ dishNumber + "]";
	}

}
