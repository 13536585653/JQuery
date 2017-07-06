package com.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * 实现数据的输出
 * 
 * 创建一个管道 - EndPoint - 服务器的端点程序
 * 
 * @author Administrator
 * 
 * 
 */
@ServerEndpoint("/test")
public class EchoSocket {
	
	public EchoSocket() {
		System.out.println("Websocket...");
	}

	// @OnOpen:打开连接时，触发的响应事件
	@OnOpen
	public void open(Session session) {
		System.out.println("开始连接了。。。。" + session.getId());
	}

	// @onClose:关闭连接时，触发的响应事件
	@OnClose
	public void close(Session session) {
		System.out.println("sessionID:" + session.getId() + "已经关闭了...");
	}

	// @OnMessage:发送数据时，触发的响应事件
	@OnMessage
	/**
	 * 
	 * @param session 管道的会话
	 * @param msg		客户端向服务器发送的数据
	 */
	public void message(Session session, String msg) {
		
		
		System.out.println("客户端发送过来的数据："+msg);
		
		//服务器向客户端发送数据
		try {
			session.getBasicRemote().sendText("hello,china!") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
