package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.ssh.dao.EmpDao;
import com.ssh.entity.Emp;
import com.ssh.entity.User;


public class EmpDaoImpl extends HibernateDaoSupport implements EmpDao {
	//���Ա��
	@Override
	public void add(Emp emp) {
		this.getHibernateTemplate().save(emp);	
	}
	
	//��ѯԱ��
	@SuppressWarnings("all")
	@Override
	public List<Emp> findAll() {
		 
		return (List<Emp>) this.getHibernateTemplate().find("from Emp");
	}
	//�Ȳ�ѯ��ɾ��
	@Override
	public Emp findById(int eid) {
		
		return this.getHibernateTemplate().get(Emp.class, eid);
	}
	//��ɾ��
	@Override
	public void delete(Emp emp) {
		
		this.getHibernateTemplate().delete(emp);
	}
	//���޸�
	@Override
	public void update(Emp emp) {
		
		this.getHibernateTemplate().update(emp);
	}
	//��ҳ��ѯ�ܼ�¼��
	@SuppressWarnings("all")
	@Override
	public int findCount() {
		List<Long> list=(List<Long>) this.getHibernateTemplate().find("select count(*) from Emp");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	//��ҳ��ѯÿҳ�ļ�¼����
	@Override
	public List<Emp> findPage(int begin, int pageSize) {
		//�������߶���
		DetachedCriteria criteria=DetachedCriteria.forClass(Emp.class);
		return (List<Emp>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
	}
	
}
