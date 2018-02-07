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
	
	//ģ������
	private Dept dept=new Dept();
	@Override
	public Dept getModel() {
		return dept;
	}
	//ע��service
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	//��ѯ����
	public String findAll(){
		List<Dept> list=deptService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";		
	}
	
	//��Ӳ���ҳ��
	public String addDeptPage(){
		return "addDeptPage";
	}
	//��Ӳ�������
	public String addDept(){
		deptService.add(dept);
		return "addDept";
	}
	//ɾ������
	public String deleteDept(){
		//�Ȳ�
		Integer did=dept.getDid();
		Dept dept=deptService.findById(did);
		//��ɾ��
		deptService.delete(dept);
		return "deleteDept";
	}
	//��ת���޸�ҳ��
	public String updateDeptPage(){
		//�Ȳ�
		Integer did=dept.getDid();
		Dept dept=deptService.findById(did);
		ServletActionContext.getRequest().setAttribute("dept", dept);
		return "updateDeptPage";
	}
	//�����޸ĺ������
	public String updateDept(){
		deptService.updateDept(dept);
		return "updateDept";
	}
	//��ҳ��ѯ
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
