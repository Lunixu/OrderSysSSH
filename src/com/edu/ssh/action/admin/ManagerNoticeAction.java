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
		//��ǰ�˷��͹�����message��Ϣ������application�У��Ա����Ա�ͺ��ȡ��
		ActionContext.getContext().getApplication().put("message", message);
		return null;
	}

}
