package com.edu.ssh.action.login;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

public class CodeVerifyAction {
	private String codenum;

	public String getCodenum() {
		return codenum;
	}

	public void setCodenum(String codenum) {
		this.codenum = codenum;
	}
	public String verify(){
		String msg = "";
		String codeValidate = (String)ServletActionContext.getRequest()
							.getSession().getAttribute("codeValidate");
		//如果产生的验证码和前端发过来的验证码相同
		if(codenum.equals(codeValidate))
			msg = "yes";
		else
			msg = "no";
		//将消息回送给前端
		try {
			ServletActionContext.getResponse().getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
