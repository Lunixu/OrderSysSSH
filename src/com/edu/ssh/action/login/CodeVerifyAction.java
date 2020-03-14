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
		//�����������֤���ǰ�˷���������֤����ͬ
		if(codenum.equals(codeValidate))
			msg = "yes";
		else
			msg = "no";
		//����Ϣ���͸�ǰ��
		try {
			ServletActionContext.getResponse().getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
