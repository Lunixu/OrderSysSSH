package com.edu.ssh.entity;

public class UserPosition {
	private Integer id;
	private String name;
	
	public UserPosition() {
	}

	public UserPosition(String name) {
		this.name = name;
	}

	public UserPosition(Integer id, String name) {
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
	

}
