package com.ssh.entity;

import java.util.List;

public class PageBean<T> {
	//��ǰҳ
	private Integer currenPage;
	//�ܼ�¼��
	private Integer totalCount;
	//ÿҳ��ʾ����
	private Integer pageSize;
	//��ҳ��
	private Integer totalPage;
	//��ʼλ��
	private Integer begin;
	//ÿҳ��¼��list����
	private List<T> list;
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getCurrenPage() {
		return currenPage;
	}
	public void setCurrenPage(Integer currenPage) {
		this.currenPage = currenPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	

}
