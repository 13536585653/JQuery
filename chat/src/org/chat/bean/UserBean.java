package org.chat.bean;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 用户对象
 * 
 * @author wangl
 *
 */
public class UserBean {

	// 用户
	private String userName;
	// 用户发送的消息
	private String message;
	// 接受消息的消息队列
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
