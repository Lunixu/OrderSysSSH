package com.edu.ssh.action.admin;

import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ManagerNoticeAction {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String sendNotice(){
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//将前端发送过来的message信息储存在application中，以便服务员和后厨取得
		ActionContext.getContext().getApplication().put("message", message);
		return null;
	}

}
