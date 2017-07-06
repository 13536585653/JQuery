package org.order.bean;

import java.sql.Date;

public class Menu {
	private int jx;
	private int m_id;
	private String m_name;
	private  float m_price;
	private String m_img;
	private int d_id;
	private Date m_time;
	private Dishes dishes;
	private String m_description;
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public float getM_price() {
		return m_price;
	}
	public void setM_price(float m_price) {
		this.m_price = m_price;
	}
	public String getM_img() {
		return m_img;
	}
	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public Dishes getDishes() {
		return dishes;
	}
	public void setDishes(Dishes dishes) {
		this.dishes = dishes;
	}
	public String getM_description() {
		return m_description;
	}
	public void setM_description(String m_description) {
		this.m_description = m_description;
	}
	public int getJx() {
		return jx;
	}
	public void setJx(int jx) {
		this.jx = jx;
	}
	public Date getM_time() {
		return m_time;
	}
	public void setM_time(Date m_time) {
		this.m_time = m_time;
	}

}
