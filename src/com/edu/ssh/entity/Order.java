package com.edu.ssh.entity;

import java.util.Date;
import java.util.Set;

//订单数据实体
public class Order {
	private Integer id;// 订单编号
	private Date beginTime;// 订单开始时间
	private Date endTime;// 订单结束时间
	private OrderState state;// 订单状态
	private Integer waiterId;// 处理订单的服务员编号
	private Integer tableId;// 订单所在桌号
	private Set<OrderContent> food;// 订单内容

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Date beginTime, Date endTime, OrderState state,
			Integer waiterId, Integer tableId, Set<OrderContent> food) {
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.state = state;
		this.waiterId = waiterId;
		this.tableId = tableId;
		this.food = food;
	}

	public Order(Integer id, Date beginTime, Date endTime, OrderState state,
			Integer waiterId, Integer tableId, Set<OrderContent> food) {
		this.id = id;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.state = state;
		this.waiterId = waiterId;
		this.tableId = tableId;
		this.food = food;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Set<OrderContent> getFood() {
		return food;
	}

	public void setFood(Set<OrderContent> food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", beginTime=" + beginTime + ", endTime="
				+ endTime + ", state=" + state + ", waiterId=" + waiterId
				+ ", tableId=" + tableId + ", food=" + food + "]";
	}

}
