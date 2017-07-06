package org.demo.entity;

import java.sql.Date;

public class HouseBean {
	private int hid;
	private String harea;
	private String hcartype;
	private	Date hmovedate;
	private String hcontact;
	private String hphone;
	private byte hstatus;
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHarea() {
		return harea;
	}
	public void setHarea(String harea) {
		this.harea = harea;
	}
	public String getHcartype() {
		return hcartype;
	}
	public void setHcartype(String hcartype) {
		this.hcartype = hcartype;
	}
	public Date getHmovedate() {
		return hmovedate;
	}
	public void setHmovedate(Date hmovedate) {
		this.hmovedate = hmovedate;
	}
	public String getHcontact() {
		return hcontact;
	}
	public void setHcontact(String hcontact) {
		this.hcontact = hcontact;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public byte getHstatus() {
		return hstatus;
	}
	public void setHstatus(byte hstatus) {
		this.hstatus = hstatus;
	}
	@Override
	public String toString() {
		return "HouseBean [hid=" + hid + ", harea=" + harea + ", hcartype=" + hcartype + ", hmovedate=" + hmovedate
				+ ", hcontact=" + hcontact + ", hphone=" + hphone + ", hstatus=" + hstatus + "]";
	}
	
}
