package com.ssh.service;

import java.util.List;

import com.ssh.entity.Dept;
import com.ssh.entity.PageBean;

public interface DeptService {

	List<Dept> findAll();

	void add(Dept dept);

	Dept findById(Integer did);

	void delete(Dept dept);

	void updateDept(Dept dept);

	PageBean listDeptPage(Integer currenPage);

}
