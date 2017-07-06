package com.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * ʵ�����ݵ����
 * 
 * ����һ���ܵ� - EndPoint - �������Ķ˵����
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

	// @OnOpen:������ʱ����������Ӧ�¼�
	@OnOpen
	public void open(Session session) {
		System.out.println("��ʼ�����ˡ�������" + session.getId());
	}

	// @onClose:�ر�����ʱ����������Ӧ�¼�
	@OnClose
	public void close(Session session) {
		System.out.println("sessionID:" + session.getId() + "�Ѿ��ر���...");
	}

	// @OnMessage:��������ʱ����������Ӧ�¼�
	@OnMessage
	/**
	 * 
	 * @param session �ܵ��ĻỰ
	 * @param msg		�ͻ�������������͵�����
	 */
	public void message(Session session, String msg) {
		
		
		System.out.println("�ͻ��˷��͹��������ݣ�"+msg);
		
		//��������ͻ��˷�������
		try {
			session.getBasicRemote().sendText("hello,china!") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
