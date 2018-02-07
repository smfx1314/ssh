package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.dao.DeptDao;
import com.ssh.entity.Dept;


public class DeptDaoImpl extends HibernateDaoSupport implements DeptDao {
	
	//��ѯ
	@SuppressWarnings("all")
	@Override
	public List<Dept> findAll() {
		List<Dept> list=(List<Dept>) this.getHibernateTemplate().find("from Dept");
		return list;
	}
	
	//��Ӳ���
	@Override
	public void add(Dept dept) {
		this.getHibernateTemplate().save(dept);
	}
	//�Ȳ�
	@Override
	public Dept findById(Integer did) {
		return this.getHibernateTemplate().get(Dept.class, did);
	}
	
	//��ɾ��
	@Override
	public void delete(Dept dept) {
		this.getHibernateTemplate().delete(dept);
		
	}
	//�����޸ĺ�Ĳ�������
	@Override
	public void updateDept(Dept dept) {
		this.getHibernateTemplate().save(dept);
		
	}
	
	//��ѯ�ܼ�¼��
	@Override
	public int findCount() {
		List<Long> list=(List<Long>) this.getHibernateTemplate().find("select count(*) from Dept");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Dept> findPage(int begin, int pageSize) {
		//���߶���
		DetachedCriteria criteria =DetachedCriteria.forClass(Dept.class);
		List<Dept> list=(List<Dept>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

}
