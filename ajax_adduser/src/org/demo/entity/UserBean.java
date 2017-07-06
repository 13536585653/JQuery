package org.demo.entity;

public class UserBean {
	private int id;
	private String name;
	private String password;
	private int age;
	private String address;
	
	public UserBean(){
		
	}
	public UserBean(String name,String password,int age,String address){
		this.name = name;
		this.password = password; 
		this.age = age;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", password=" + password + ", age=" + age + ", address="
				+ address + "]";
	}
	
}
