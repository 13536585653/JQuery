package org.demo.entity;

import java.sql.Timestamp;

public class UsersBean {
	private int uid;
	private String uname;
	private String upassword;
	private String usex;
	private int uage;
	private String unum;
	private String uaddress;
	private Timestamp uregTime;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	@Override
	public String toString() {
		return "UsersBean [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", usex=" + usex + ", uage="
				+ uage + ", unum=" + unum + ", uaddress=" + uaddress + ",uregTime="+uregTime+"]";
	}
	public Timestamp getUregTime() {
		return uregTime;
	}
	public void setUregTime(Timestamp uregTime) {
		this.uregTime = uregTime;
	}
	
}
