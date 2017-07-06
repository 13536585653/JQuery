package org.chat.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Message {
	private String info;
	private String message;
	private String to ;
	private Integer type;
	private List<String> usernameList;
	
	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String username,String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss") ;
		StringBuilder sb = new StringBuilder() ;
		
		if(this.type==1) {
			sb.append("<b style='color:green'>[群聊]</b>&nbsp;") ;
		} else {
			sb.append("<b style='color:red'>[私聊]</b>&nbsp;") ;
		}
		
		sb.append(username).append(" ").append(sdf.format(new Date())).append("<br/>").append(message).append("<br/>") ;
		this.message = sb.toString() ;
	}

	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return this.to + "," + this.info + "," + this.type + "," + this.message + "," + this.usernameList;
	}
	
}
