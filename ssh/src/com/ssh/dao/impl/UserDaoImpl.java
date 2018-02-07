package com.ssh.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.ssh.dao.UserDao;
import com.ssh.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	//��¼
	@SuppressWarnings("all")
	@Override
	public User login(User user) {
		//�����û��������ѯ
		List<User> list=(List<User>) this.getHibernateTemplate().find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		//����userInfo����
		if(list.size()>0){
			return list.get(0);
		}
			
		return null;
	}

}
