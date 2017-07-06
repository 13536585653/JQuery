package org.demo.entity;

import java.sql.Date;

public class Book {
	private int bid;
	private String bname;
	private Date createTime;
	private int tid;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", createTime=" + createTime + ", tid=" + tid + "]";
	}

}
