package com.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.DeptDao;
import com.ssh.entity.Dept;
import com.ssh.entity.PageBean;
import com.ssh.service.DeptService;
@Transactional
public class DeptServiceImpl implements DeptService{
	//注入dao
	private DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	//查询
	@Override
	public List<Dept> findAll() {
		
		return deptDao.findAll();
	}
	//添加部门
	@Override
	public void add(Dept dept) {
		deptDao.add(dept);
	}
	//先查
	@Override
	public Dept findById(Integer did) {
		
		return deptDao.findById(did);
	}
	//后删
	@Override
	public void delete(Dept dept) {
		
		deptDao.delete(dept);
	}
	//保持修改后的部门数据
	@Override
	public void updateDept(Dept dept) {
		deptDao.updateDept(dept);
		
	}
	//部门分页查询
	@Override
	public PageBean<Dept> listDeptPage(Integer currenPage) {
		//创建pageBean对象，封装属性
		PageBean<Dept> pageBean=new PageBean<Dept>();
		//封装当前页
		pageBean.setCurrenPage(currenPage);
		//封装每页显示的条数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=deptDao.findCount();
		pageBean.setTotalCount(totalCount);
		//开始位置
		int begin=(currenPage-1)*pageSize;
		//封装总页数
		int totalPage=0;
		if(totalCount%pageSize==0){
			totalPage=totalCount%pageSize;
		}else{
			totalPage=totalCount%pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//封装每页显示的list数据
		List<Dept> list=deptDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
}
