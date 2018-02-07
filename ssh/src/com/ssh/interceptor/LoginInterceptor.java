package com.ssh.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {
	private static final long serialVersionUID = 1L;
	/**
	 * 这个方法里写拦截器逻辑
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session里面是否有username的值
		//得到session
		Object obj=ServletActionContext.getRequest().getSession().getAttribute("u");
		
		//判断
		if(obj !=null){
			//做类似于过滤器放行操作，执行action
			
			return invocation.invoke();
		}else{
			return "loginfail";
		}
		
	}

}