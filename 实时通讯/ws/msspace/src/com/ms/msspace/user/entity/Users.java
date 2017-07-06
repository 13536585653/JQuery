package com.ms.msspace.user.entity;

import java.util.Date;

/**
 * 用户信息描述
 * @author Ms
 *
 */
public class Users {
	/**
	 * ID 用户ID
	 */
	private String user_ID ;
	private String username;
	private String password;
	private String sex;
	private Date birth ;
	private String signature;
	private String address;
	private Date datetime ;
	private String email;
	private int state;
	private int grade ;	
	private String micro_blog;	
	private String label ;
	private  int follow;
	private long fans;
	private int collection ;
	private String letterID ;
	
	
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMicro_blog() {
		return micro_blog;
	}
	public void setMicro_blog(String micro_blog) {
		this.micro_blog = micro_blog;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	public long getFans() {
		return fans;
	}
	public void setFans(long fans) {
		this.fans = fans;
	}
	public int getCollection() {
		return collection;
	}
	public void setCollection(int collection) {
		this.collection = collection;
	}
	public String getLetterID() {
		return letterID;
	}
	public void setLetterID(String letterID) {
		this.letterID = letterID;
	}
	
}
