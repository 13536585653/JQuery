package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 封装消息的对象
 * 
 * @author Administrator
 * 
 */
public class Message {
	// 提示
	private String info;

	// 发送的消息
	private String message;

	// 接收者
	private String to;
	// 状态类型:1->群聊,2->私聊
	private Integer type = 1 ;

	// 显示用户列表
	private List<String> usernameList;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String username,String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		StringBuilder sb = new StringBuilder();

		if (this.type == 1) {
			sb.append("<b style='color:green'>[群聊]</b>&nbsp;");
		} else {
			sb.append("<b style='color:red'>[私聊]</b>&nbsp;");
		}

		sb.append(username).append(" ").append(sdf.format(new Date()))
				.append("<br/>").append(message).append("<br/>");
		
		this.message = sb.toString();
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

	public List<String> getUsernameList() {
		return usernameList;
	}

	public void setUsernameList(List<String> usernameList) {
		this.usernameList = usernameList;
	}

}
