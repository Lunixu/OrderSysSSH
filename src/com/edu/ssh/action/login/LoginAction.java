package com.edu.ssh.action.login;

import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;
import com.edu.ssh.service.user.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction implements ModelDriven<User>{

	private IUserService myUserService;
	
	public IUserService getMyUserService() {
		return myUserService;
	}
	public void setMyUserService(IUserService myUserService) {
		this.myUserService = myUserService;
	}
	private User user;
	@Override
	public User getModel() {
		if(user == null)
			user = new User();
		return user;
	}
	
	public String validate(){
		User u = myUserService.validate(user);
		System.out.println(u.getId());
		int position = u.getPosition().getId();
		if(position == 1){
			ServletActionContext.getRequest().getSession().setAttribute("acount", user.getAcount());
			ServletActionContext.getRequest().getSession().setAttribute("admin", u);
			ServletActionContext.getRequest().getSession().setAttribute("adminId", u.getId());
			return "admin";
		}
		else if(position == 2){
			ServletActionContext.getRequest().getSession().setAttribute("acount", user.getAcount());
			ServletActionContext.getRequest().getSession().setAttribute("waiter", u);
			ServletActionContext.getRequest().getSession().setAttribute("waiterId", u.getId());
			return "waiter";
		}
		else if(position == 3){
			ServletActionContext.getRequest().getSession().setAttribute("acount", user.getAcount());
			ServletActionContext.getRequest().getSession().setAttribute("kitchen", u);
			ServletActionContext.getRequest().getSession().setAttribute("kitchenId", u.getId());
			return "kitchen";
		}
		else{
			ServletActionContext.getRequest().getSession().setAttribute("error", "对不起，该用户不存在!");
			return "fail";
		}
	}
	

}
