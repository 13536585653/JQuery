package org.demo.entity;

public class Users {
	private int uid;
	private String userName;
	private String password;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", userName=" + userName + ", password=" + password + "]";
	}
}
