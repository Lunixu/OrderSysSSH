package com.edu.ssh.entity;

public class VIPCustomer {
	private Integer id; //客户编号
	private String name;//客户姓名
	private char sex; //客户性别
	private String phoneNumber; //客户手机号
	private Integer dinningTimes; //客户消费次数
	private Double dinningSum; //客户消费总和
	
	public VIPCustomer() {
		
	}
	public VIPCustomer(String name, char sex, String phoneNumber,
			Integer dinningTimes, Double dinningSum) {
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.dinningTimes = dinningTimes;
		this.dinningSum = dinningSum;
	}
	public VIPCustomer(Integer id, String name, char sex, String phoneNumber,
			Integer dinningTimes, Double dinningSum) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.dinningTimes = dinningTimes;
		this.dinningSum = dinningSum;
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
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getDinningTimes() {
		return dinningTimes;
	}
	public void setDinningTimes(Integer dinningTimes) {
		this.dinningTimes = dinningTimes;
	}
	public Double getDinningSum() {
		return dinningSum;
	}
	public void setDinningSum(Double dinningSum) {
		this.dinningSum = dinningSum;
	}
	
	
	@Override
	public String toString() {
		return "VIPCustomer [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", phoneNumber=" + phoneNumber + ", dinningTimes="
				+ dinningTimes + ", dinningSum=" + dinningSum + "]";
	}
	
	
	
}
