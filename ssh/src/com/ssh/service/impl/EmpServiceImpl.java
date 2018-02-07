package com.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.EmpDao;
import com.ssh.entity.Emp;
import com.ssh.entity.PageBean;
import com.ssh.service.EmpService;

@Transactional
public class EmpServiceImpl implements EmpService {
	//ע��dao
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	//���Ա��
	@Override
	public void add(Emp emp) {
		
		empDao.add(emp);
	}
	//��ѯԱ��
	@Override
	public List<Emp> findAll() {
		
		return empDao.findAll();
	}
	//�ֲ�ѯ��ɾ��
	@Override
	public Emp findById(int eid) {
		return empDao.findById(eid);
	}
	@Override
	public void delete(Emp emp) {
		
		empDao.delete(emp);
	}
	//�޸�
	@Override
	public void update(Emp emp) {
		
		empDao.update(emp);
	}
	//��ҳ��ѯ:��װ��ҳ���ݵ�pageBean������
	@Override
	public PageBean<Emp> listPage(Integer currenPage) {
		//����pageBean����
		PageBean<Emp> pageBean=new PageBean<Emp>();
		//��װ��ǰҳ
		pageBean.setCurrenPage(currenPage);
		//ÿҳ��ʾ����
		int pageSize=5;
		//��װ�ܼ�¼��
		int totalCount=empDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		int totalPage=0;
		if(totalCount%pageSize==0){//����
			totalPage=totalCount%pageSize;
		}else{//��������Ҫ��1
			totalPage=totalCount%pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//��ʼλ�ã�����ǰҳ��-1��*ÿҳ��ʾ�ļ�¼��
		int begin=(currenPage-1)*pageSize;
		//��װÿҳ��¼������
		List<Emp> list=empDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	
	
	
	
	
	
}
