package com.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entity.Dept;
import com.ssh.entity.Emp;
import com.ssh.entity.PageBean;
import com.ssh.service.DeptService;
import com.ssh.service.EmpService;

public class EmpAction extends ActionSupport implements ModelDriven<Emp>{
	private static final long serialVersionUID = 1L;
	//模型驱动
	private Emp emp=new Emp();
	@Override
	public Emp getModel() {
		return emp;
	}
	
	//注入empService
	private EmpService empService;
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	//注入deptService
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	/**
	 * 上传文件
	 * 上传文件的名称
	 */
	//变量名称需要是表单里面文件上传的name值
	private File upload;
	//变量名称需要是表单里面文件上传的name值+FileName
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	//跳转到添加页面
	public String addPage(){
		InputStream is=null;
		OutputStream os=null;
		//判断是否需要上传文件
		if(upload !=null){
			try {
				/*//在服务器文件夹里面创建文件
				File serverFile=new File("/F:\\sshupload"+"\\"+uploadFileName);
				//把上传文件复制到服务器文件里面
				FileUtils.copyFile(upload, serverFile);*/
				
				String root = ServletActionContext.getServletContext().getRealPath("F:\\sshupload");
		        
		         is = new FileInputStream(upload);
		        
		         os = new FileOutputStream(new File(root, uploadFileName));		           
		        
		        byte[] buffer = new byte[500];
		        
		        
		        while(is.read(buffer, 0, buffer.length) !=-1);
		        {
		            os.write(buffer);
		        }
		        
		       
			} catch (IOException e) {
				
				e.printStackTrace();
			}finally{
				 try {
					os.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			     try {
					is.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		//获取部门信息
		List<Dept> list=deptService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "addPage";
	}
	//添加用户
	public String add(){
		empService.add(emp);
		return "add";
	}
	//查询用户
	public String findAll(){
		List<Emp> list=empService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";
	}

	//删除员工
	public String delete(){
		//先查询
		int eid=emp.getEid();
		Emp emp=empService.findById(eid);
		//在删除
		empService.delete(emp);
		return "delete";
	}
	//修改
	//先查询数据输入到修改页面
	public String updatePage(){
		//根据empid查询
		int eid=emp.getEid();
		Emp emp=empService.findById(eid);
		//查找dept部门信息
		List<Dept> list=deptService.findAll();
		ServletActionContext.getRequest().setAttribute("emp", emp);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "updatePage";
	}
	//在修改
	public String update(){
		
		empService.update(emp);
		return "update";
	}
	/**
	 * 分页查询:属性封装
	 * @return
	 */
	private Integer currenPage;
	public Integer getCurrenPage() {
		return currenPage;
	}
	public void setCurrenPage(Integer currenPage) {
		this.currenPage = currenPage;
	}
	
	public String listPage(){
		PageBean pageBean=empService.listPage(currenPage);
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
//方法1	ActionContext.getContext().getValueStack().push(pageBean);
//方法2	ActionContext.getContext().put("pageBean", pageBean);
		return "listPage";
	}
}
