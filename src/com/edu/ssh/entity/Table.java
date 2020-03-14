package com.edu.ssh.entity;

//餐桌
public class Table {
	private Integer id;//编号
	private char isFree;//是否空闲
	private Integer size;//餐桌大小
	public Table() {
		// TODO Auto-generated constructor stub
	}
	public Table(char isFree, Integer size) {
		this.isFree = isFree;
		this.size = size;
	}
	public Table(Integer id, char isFree, Integer size) {
		this.id = id;
		this.isFree = isFree;
		this.size = size;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public char getIsFree() {
		return isFree;
	}
	public void setIsFree(char isFree) {
		this.isFree = isFree;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	
}
