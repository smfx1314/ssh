package com.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.DeptDao;
import com.ssh.entity.Dept;
import com.ssh.entity.PageBean;
import com.ssh.service.DeptService;
@Transactional
public class DeptServiceImpl implements DeptService{
	//ע��dao
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	//��ѯ
	@Override
	public List<Dept> findAll() {
		
		return deptDao.findAll();
	}
	//��Ӳ���
	@Override
	public void add(Dept dept) {
		deptDao.add(dept);
	}
	//�Ȳ�
	@Override
	public Dept findById(Integer did) {
		
		return deptDao.findById(did);
	}
	//��ɾ
	@Override
	public void delete(Dept dept) {
		
		deptDao.delete(dept);
	}
	//�����޸ĺ�Ĳ�������
	@Override
	public void updateDept(Dept dept) {
		deptDao.updateDept(dept);
		
	}
	//���ŷ�ҳ��ѯ
	@Override
	public PageBean<Dept> listDeptPage(Integer currenPage) {
		//����pageBean���󣬷�װ����
		PageBean<Dept> pageBean=new PageBean<Dept>();
		//��װ��ǰҳ
		pageBean.setCurrenPage(currenPage);
		//��װÿҳ��ʾ������
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount=deptDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��ʼλ��
		int begin=(currenPage-1)*pageSize;
		//��װ��ҳ��
		int totalPage=0;
		if(totalCount%pageSize==0){
			totalPage=totalCount%pageSize;
		}else{
			totalPage=totalCount%pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//��װÿҳ��ʾ��list����
		List<Dept> list=deptDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
}
