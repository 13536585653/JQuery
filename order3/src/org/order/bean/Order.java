package org.order.bean;

import java.sql.Date;

public class Order {
	
	private int o_id ;
	private String o_number ;
	private Date o_time ;
	private String o_way ;
	private int o_num;
	private float o_sum ;
	private int o_state ;
	private UserBean user;
	private Menu me;
	private String message;
	public int getO_id() {
		return o_id;
	}
	public void setO_id(int o_id) {
		this.o_id = o_id;
	}
	public String getO_number() {
		return o_number;
	}
	public void setO_number(String o_number) {
		this.o_number = o_number;
	}
	public Date getO_time() {
		return o_time;
	}
	public void setO_time(Date o_time) {
		this.o_time = o_time;
	}
	public String getO_way() {
		return o_way;
	}
	public void setO_way(String o_way) {
		this.o_way = o_way;
	}
	public float getO_sum() {
		return o_sum;
	}
	public void setO_sum(float o_sum) {
		this.o_sum = o_sum;
	}
	public int getO_state() {
		return o_state;
	}
	public void setO_state(int o_state) {
		this.o_state = o_state;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getO_m_id() {
		return o_m_id;
	}
	public void setO_m_id(int o_m_id) {
		this.o_m_id = o_m_id;
	}
	public int getO_u_id() {
		return o_u_id;
	}
	public void setO_u_id(int o_u_id) {
		this.o_u_id = o_u_id;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public Menu getMe() {
		return me;
	}
	public void setMe(Menu me) {
		this.me = me;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	private Menu menu;
	private int o_m_id ;
	private int o_u_id;
		
}
