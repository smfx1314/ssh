package com.ssh.service;

import java.util.List;

import com.ssh.entity.Emp;
import com.ssh.entity.PageBean;

public interface EmpService {

	void add(Emp emp);

	List<Emp> findAll();

	Emp findById(int eid);

	void delete(Emp emp);

	void update(Emp emp);

	PageBean listPage(Integer currenPage);


}
