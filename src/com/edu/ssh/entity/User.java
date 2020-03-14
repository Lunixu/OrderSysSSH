package com.edu.ssh.entity;

public class User {

	private Integer id;
	private String acount;
	private String pwd;
	private String faceImg;
	private String name;
	private char sex;
	private String phoneNumber;
	private String address;
	private UserPosition position;//
	
	public User() {
		super();
	}
	public User(String acount, String pwd, String faceImg, String name,
			char sex, String phoneNumber, String address, UserPosition position) {
		super();
		this.acount = acount;
		this.pwd = pwd;
		this.faceImg = faceImg;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
	}
	public User(Integer id, String acount, String pwd, String faceImg,
			String name, char sex, String phoneNumber, String address,
			UserPosition position) {
		super();
		this.id = id;
		this.acount = acount;
		this.pwd = pwd;
		this.faceImg = faceImg;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.position = position;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAcount() {
		return acount;
	}
	public void setAcount(String acount) {
		this.acount = acount;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFaceImg() {
		return faceImg;
	}
	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserPosition getPosition() {
		return position;
	}
	public void setPosition(UserPosition position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", acount=" + acount + ", pwd=" + pwd
				+ ", faceImg=" + faceImg + ", name=" + name + ", sex=" + sex
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
}
