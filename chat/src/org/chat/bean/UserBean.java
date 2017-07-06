package org.chat.bean;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * �û�����
 * 
 * @author wangl
 *
 */
public class UserBean {

	// �û�
	private String userName;
	// �û����͵���Ϣ
	private String message;
	// ������Ϣ����Ϣ����
	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BlockingQueue<String> getQueue() {
		return queue;
	}

	public void setQueue(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
