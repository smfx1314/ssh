package com.ssh.dao;

import java.util.List;

import com.ssh.entity.Dept;

public interface DeptDao {

	List<Dept> findAll();

	void add(Dept dept);

	Dept findById(Integer did);

	void delete(Dept dept);

	void updateDept(Dept dept);

	int findCount();

	List<Dept> findPage(int begin, int pageSize);

}
