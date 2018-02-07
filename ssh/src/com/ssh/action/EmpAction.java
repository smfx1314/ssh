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
	//ģ������
	private Emp emp=new Emp();
	@Override
	public Emp getModel() {
		return emp;
	}
	
	//ע��empService
	private EmpService empService;
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	//ע��deptService
	private DeptService deptService;
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
	/**
	 * �ϴ��ļ�
	 * �ϴ��ļ�������
	 */
	//����������Ҫ�Ǳ������ļ��ϴ���nameֵ
	private File upload;
	//����������Ҫ�Ǳ������ļ��ϴ���nameֵ+FileName
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
	//��ת�����ҳ��
	public String addPage(){
		InputStream is=null;
		OutputStream os=null;
		//�ж��Ƿ���Ҫ�ϴ��ļ�
		if(upload !=null){
			try {
				/*//�ڷ������ļ������洴���ļ�
				File serverFile=new File("/F:\\sshupload"+"\\"+uploadFileName);
				//���ϴ��ļ����Ƶ��������ļ�����
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
		
		//��ȡ������Ϣ
		List<Dept> list=deptService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "addPage";
	}
	//����û�
	public String add(){
		empService.add(emp);
		return "add";
	}
	//��ѯ�û�
	public String findAll(){
		List<Emp> list=empService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "findAll";
	}

	//ɾ��Ա��
	public String delete(){
		//�Ȳ�ѯ
		int eid=emp.getEid();
		Emp emp=empService.findById(eid);
		//��ɾ��
		empService.delete(emp);
		return "delete";
	}
	//�޸�
	//�Ȳ�ѯ�������뵽�޸�ҳ��
	public String updatePage(){
		//����empid��ѯ
		int eid=emp.getEid();
		Emp emp=empService.findById(eid);
		//����dept������Ϣ
		List<Dept> list=deptService.findAll();
		ServletActionContext.getRequest().setAttribute("emp", emp);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "updatePage";
	}
	//���޸�
	public String update(){
		
		empService.update(emp);
		return "update";
	}
	/**
	 * ��ҳ��ѯ:���Է�װ
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
//����1	ActionContext.getContext().getValueStack().push(pageBean);
//����2	ActionContext.getContext().put("pageBean", pageBean);
		return "listPage";
	}
}
