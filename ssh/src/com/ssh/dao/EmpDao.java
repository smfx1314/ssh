package com.ssh.dao;

import java.util.List;

import com.ssh.entity.Emp;

public interface EmpDao {

	void add(Emp emp);

	List<Emp> findAll();

	Emp findById(int eid);

	void delete(Emp emp);

	void update(Emp emp);

	int findCount();

	List<Emp> findPage(int begin, int pageSize);


}
