package com.edu.ssh.action.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.edu.ssh.entity.User;
import com.edu.ssh.entity.UserPosition;
import com.edu.ssh.service.user.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction implements ModelDriven<User>{
	
	private IUserService userService;
	private Integer currentPage;
	private User user;
	private File img;
	private String imgFileName;
	private Integer myposition;
	private String fileText;
	public static String imgTxt;//用于存放用户头像路径
	
	private String keyword;
	
	
	public String getFileText() {
		return fileText;
	}

	public void setFileText(String fileText) {
		this.fileText = fileText;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getMyposition() {
		return myposition;
	}

	public void setMyposition(Integer myposition) {
		this.myposition = myposition;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	private void showByPage(int pageSize){
		if(currentPage == null)
			currentPage = 1;
		int pageTotal = userService.getPageCount(pageSize);
		ActionContext.getContext().getSession().put("pageTotal", pageTotal);
		ActionContext.getContext().getSession().put("currentPage", currentPage);
		List<User> users = userService.getUserByPage(currentPage, pageSize);
		ActionContext.getContext().getSession().put("users", users);
	}
	
	public String list(){
		List<UserPosition> positions = userService.getAllPosition();
		ActionContext.getContext().getSession().put("positions", positions);
		showByPage(5);
		return "list";
	}
	
	public String delete(){
		userService.delete(user);
		return "success";
	}

	@Override
	public User getModel() {
		if(user == null)
			user=new User();
		return user;
	}

	public String upd(){
		User oneuser = userService.getOneUserToUpdate(user.getId());
		imgTxt = oneuser.getFaceImg();
		ActionContext.getContext().getSession().put("oneuser", oneuser);
		return "upd";
		
	}
	public String update(){
		if(fileText.endsWith(imgTxt)){
			user.setFaceImg(imgTxt);
		}else{
			String path = ServletActionContext.getServletContext().getRealPath("/imgs");
			File file = new File(path,imgFileName);
			try {
				FileUtils.copyFile(img, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			user.setFaceImg("/OrderSysSSH/imgs/"+imgFileName);
		}
		UserPosition position = new UserPosition();
		position.setId(myposition);
		position.setName(userService.getPositionById(myposition).getName());
		user.setPosition(position);
		userService.update(user);
		return "success";
	}
	
	
	public String add(){
		String path = ServletActionContext.getServletContext().getRealPath("/imgs");
		File file = new File(path,imgFileName);
		try {
			FileUtils.copyFile(img, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		user.setFaceImg("/OrderSysSSH/imgs/"+imgFileName);
		UserPosition position = new UserPosition();
		position.setId(myposition);
		position.setName(userService.getPositionById(myposition).getName());
		user.setPosition(position);
		userService.save(user);
		return "success";
	}
	
	public String search(){
		
		Long count = userService.getCountByKey(keyword);
		List<User> users=userService.getUsersByKey(keyword);
		
		ActionContext.getContext().getSession().put("countbykey", count);
		ActionContext.getContext().getSession().put("usersbykey", users);
		
		return "search";
	}
	
}
