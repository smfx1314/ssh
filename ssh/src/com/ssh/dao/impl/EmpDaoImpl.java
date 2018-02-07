package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.ssh.dao.EmpDao;
import com.ssh.entity.Emp;
import com.ssh.entity.User;


public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {
	//添加员工
	@Override
	public void add(Emp emp) {
		this.getHibernateTemplate().save(emp);	
	}
	
	//查询员工
	@SuppressWarnings("all")
	@Override
	public List<Emp> findAll() {
		 
		return (List<Emp>) this.getHibernateTemplate().find("from Emp");
	}
	//先查询在删除
	@Override
	public Emp findById(int eid) {
		
		return this.getHibernateTemplate().get(Emp.class, eid);
	}
	//在删除
	@Override
	public void delete(Emp emp) {
		
		this.getHibernateTemplate().delete(emp);
	}
	//在修改
	@Override
	public void update(Emp emp) {
		
		this.getHibernateTemplate().update(emp);
	}
	//分页查询总记录数
	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Long> list=(List<Long>) this.getHibernateTemplate().find("select count(*) from Emp");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//分页查询每页的记录数据
	@Override
	public List<Emp> findPage(int begin, int pageSize) {
		//创建离线对象
		DetachedCriteria criteria=DetachedCriteria.forClass(Emp.class);
		return (List<Emp>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}
	
}
