package com.edu.ssh.entity;

//订单状态数据实体
public class OrderState {
	private Integer id; // 订单状态编号
	private String name; // 订单状态名称

	public OrderState() {
		// TODO Auto-generated constructor stub
	}

	public OrderState(String name) {
		this.name = name;
	}

	public OrderState(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "OrderState [id=" + id + ", name=" + name + "]";
	}

}
