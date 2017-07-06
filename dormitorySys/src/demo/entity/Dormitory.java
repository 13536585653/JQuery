package demo.entity;

import java.sql.Date;

public class Dormitory {
	private String dormitoryId;
	private String stuName;
	private String stuSex;
	private String clsName;
	private Date inDate;
	private int bedNo;
	
	//写各属性的get、set方法
	public String getDormitoryId() {
		return dormitoryId;
	}
	public void setDormitoryId(String dormitoryId) {
		this.dormitoryId = dormitoryId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public int getBedNo() {
		return bedNo;
	}
	public void setBedNo(int bedNo) {
		this.bedNo = bedNo;
	}
	@Override
	public String toString() {
		return "Dormitory [dormitoryId=" + dormitoryId + ", stuName=" + stuName + ", stuSex=" + stuSex + ", clsName="
				+ clsName + ", inDate=" + inDate + ", bedNo=" + bedNo + "]";
	}
	
}
