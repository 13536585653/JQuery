package org.order.bean;

//������ɫʵ��
public class RoleBean {
	//��ɫ����
	private int rid;
	private String rtype;
	private float r_ids;
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
	public float getR_ids() {
		return r_ids;
	}
	public void setR_ids(float r_ids) {
		this.r_ids = r_ids;
	}
	
	
}
