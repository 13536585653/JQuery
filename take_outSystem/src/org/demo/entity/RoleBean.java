package org.demo.entity;

//创建角色实体
public class RoleBean {
	//角色属性
	private int rid;
	private String rtype;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	@Override
	public String toString() {
		return "RoleBean [rid=" + rid + ", rtype=" + rtype + "]";
	}
	
	
}
