package org.order.bean;

public class JingxuanMenuBean {
	private int id;
	private String m_name;
	private String fname;
	private String tecont;
	private float  price;
	private Dishes type_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTecont() {
		return tecont;
	}
	public void setTecont(String tecont) {
		this.tecont = tecont;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Dishes getType_id() {
		return type_id;
	}
	public void setType_id(Dishes type_id) {
		this.type_id = type_id;
	}
	
	
	
}
