package com.edu.ssh.action.waiter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class WaiterNoticeAction {
	
	
	public String dealNotice(){
		String message = (String)ActionContext.getContext().getApplication().get("message");
		ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
		try {
			ServletActionContext.getRequest().setCharacterEncoding("utf-8");
			ServletActionContext.getResponse().getWriter().print(message);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
