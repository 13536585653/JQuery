package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ��װ��Ϣ�Ķ���
 * 
 * @author Administrator
 * 
 */
public class Message {
	// ��ʾ
	private String info;

	// ���͵���Ϣ
	private String message;

	// ������
	private String to;
	// ״̬����:1->Ⱥ��,2->˽��
	private Integer type = 1 ;

	// ��ʾ�û��б�
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
			sb.append("<b style='color:green'>[Ⱥ��]</b>&nbsp;");
		} else {
			sb.append("<b style='color:red'>[˽��]</b>&nbsp;");
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
