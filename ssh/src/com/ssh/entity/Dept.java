package com.ssh.entity;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private Integer did;
	private String dname;
	private Set<Emp> setEmp=new HashSet<Emp>();
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Set<Emp> getSetEmp() {
		return setEmp;
	}
	public void setSetEmp(Set<Emp> setEmp) {
		this.setEmp = setEmp;
	}
	
}
