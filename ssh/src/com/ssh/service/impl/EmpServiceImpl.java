package com.ssh.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.EmpDao;
import com.ssh.entity.Emp;
import com.ssh.entity.PageBean;
import com.ssh.service.EmpService;

@Transactional
public class EmpServiceImpl implements EmpService {
	//注入dao
	private EmpDao empDao;
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	//添加员工
	@Override
	public void add(Emp emp) {
		
		empDao.add(emp);
	}
	//查询员工
	@Override
	public List<Emp> findAll() {
		
		return empDao.findAll();
	}
	//现查询在删除
	@Override
	public Emp findById(int eid) {
		return empDao.findById(eid);
	}
	@Override
	public void delete(Emp emp) {
		
		empDao.delete(emp);
	}
	//修改
	@Override
	public void update(Emp emp) {
		
		empDao.update(emp);
	}
	//分页查询:封装分页数据到pageBean对象中
	@Override
	public PageBean<Emp> listPage(Integer currenPage) {
		//创建pageBean对象
		PageBean<Emp> pageBean=new PageBean<Emp>();
		//封装当前页
		pageBean.setCurrenPage(currenPage);
		//每页显示几条
		int pageSize=5;
		//封装总记录数
		int totalCount=empDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		int totalPage=0;
		if(totalCount%pageSize==0){//整除
			totalPage=totalCount%pageSize;
		}else{//不能整除要加1
			totalPage=totalCount%pageSize+1;
		}
		pageBean.setTotalPage(totalPage);
		//开始位置：（当前页数-1）*每页显示的记录数
		int begin=(currenPage-1)*pageSize;
		//封装每页记录的数据
		List<Emp> list=empDao.findPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	
	
	
	
	
	
	
}
