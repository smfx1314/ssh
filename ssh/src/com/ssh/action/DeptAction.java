package com.ssh.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entity.Dept;
import com.ssh.entity.PageBean;
import com.ssh.service.DeptService;

public class DeptAction extends ActionSupport implements ModelDriven<Dept>{
	private static final long serialVersionUID = 1L;
	
	//模型驱动
	private Dept dept=new Dept();
	@Override
	public Dept getModel() {
		return dept;
	}
	//注入service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	//查询部门
	public String findAll(){
		List<Dept> list=deptService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";		
	}
	
	//添加部门页面
	public String addDeptPage(){
		return "addDeptPage";
	}
	//添加部门数据
	public String addDept(){
		deptService.add(dept);
		return "addDept";
	}
	//删除部门
	public String deleteDept(){
		//先查
		Integer did=dept.getDid();
		Dept dept=deptService.findById(did);
		//后删除
		deptService.delete(dept);
		return "deleteDept";
	}
	//跳转到修改页面
	public String updateDeptPage(){
		//先查
		Integer did=dept.getDid();
		Dept dept=deptService.findById(did);
		ServletActionContext.getRequest().setAttribute("dept", dept);
		return "updateDeptPage";
	}
	//保持修改后的数据
	public String updateDept(){
		deptService.updateDept(dept);
		return "updateDept";
	}
	//分页查询
	private Integer currenPage;
	public Integer getCurrenPage() {
		return currenPage;
	}
	public void setCurrenPage(Integer currenPage) {
		this.currenPage = currenPage;
	}

	public String listDeptPage(){
		PageBean pageBean=deptService.listDeptPage(currenPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listDeptPage";
	}
}
