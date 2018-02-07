package com.ssh.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entity.User;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = -635040790332368558L;
	
	//注入service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//模型驱动
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	//属性封装获取用户名和密码
//	private String username;
//	private String password;
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	//用户登录
	public String login(){
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
		//调用userService方法
		User u=userService.login(user);
		if(u !=null){//成功
			//使用session保持登录状态
			ServletActionContext.getRequest().getSession().setAttribute("u", u);
//			ActionContext.getContext().getSession().put("u", u);
			return "loginsuccess";
		}else{
			this.addActionError("用户名或密码错误");
			return "loginfail";
		}
	}
	
}
