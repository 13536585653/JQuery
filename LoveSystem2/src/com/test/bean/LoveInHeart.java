package com.test.bean;

import java.sql.Date;

public class LoveInHeart {
	private int lid;
	private String lname;
	private String lsex;
	private Date ltime;
	private int lmoney;
	@Override
	public String toString() {
		return "LoveInHeart [lid=" + lid + ", lname=" + lname + ", lsex=" + lsex + ", ltime=" + ltime + ", lmoney="
				+ lmoney + "]";
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLsex() {
		return lsex;
	}
	public void setLsex(String lsex) {
		this.lsex = lsex;
	}
	public Date getLtime() {
		return ltime;
	}
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	public int getLmoney() {
		return lmoney;
	}
	public void setLmoney(int lmoney) {
		this.lmoney = lmoney;
	}

}
