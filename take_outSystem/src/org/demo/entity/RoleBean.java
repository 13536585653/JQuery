package org.demo.entity;

//������ɫʵ��
public class RoleBean {
	//��ɫ����
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
