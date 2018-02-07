package com.ssh.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entity.User;
import com.ssh.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = -635040790332368558L;
	
	//ע��service
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//ģ������
	private User user=new User();
	@Override
	public User getModel() {
		return user;
	}
	//���Է�װ��ȡ�û���������
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
	//�û���¼
	public String login(){
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
		//����userService����
		User u=userService.login(user);
		if(u !=null){//�ɹ�
			//ʹ��session���ֵ�¼״̬
			ServletActionContext.getRequest().getSession().setAttribute("u", u);
//			ActionContext.getContext().getSession().put("u", u);
			return "loginsuccess";
		}else{
			this.addActionError("�û������������");
			return "loginfail";
		}
	}
	
}
