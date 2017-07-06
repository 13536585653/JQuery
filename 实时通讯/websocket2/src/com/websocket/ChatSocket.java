package com.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.entity.Message;
import com.google.gson.Gson;

/**
 * ʵ����������
 * @author Administrator
 *
 */

@ServerEndpoint("/chat")
public class ChatSocket {
	
	//��ǰ��¼���û�
	private String username ;
	
	//�����е�Session�ռ���Map������
	/**
	 * Ϊ��ʵ����ϢȺ��/˽����׼��
	 * Map�����е�String���û�������
	 * Map�����е�Session���û���ͨѶ�ܵ�
	 * 
	 * ����ΪʲôҪ�û�����Ϊ��,��Ϊ��ʱ��ͨ�������,�ҵ����Ӧ�Ĺܵ�����˽��
	 */
	private static Map<String,Session> sessionMap = new HashMap<String,Session>() ;
	
	//�û��б�
	private static List<String> userList = new ArrayList<String>() ;
	

	@OnOpen
	public void open(Session session) {//��ǰ�ܵ��ĻỰ
		//System.out.println("chat Socket��������");
		//��ȡ�ͻ��˴��ݹ����Ĳ���
		String queryString = session.getQueryString() ;
		//System.out.println("-->"+queryString);
		
		//this.username = queryString.substring(queryString.charAt('=')+1,queryString.length()) ;
		this.username = queryString.split("=")[1] ;
		sessionMap.put(this.username, session) ;//�ѵ�ǰ��¼�������û������Ӧ�Ĺܵ�����ӵ�Map������
		
		userList.add(this.username) ;//���û���ӵ��û��б�
		
		//��Ҫ��Ӧ�����ݷ�װ��Message������
		Message message = new Message() ;
		
		message.setInfo("��ӭ " + this.username + " ����������") ;
		
		//Ϊ����ÿһ���û��Ľ��涼��ʾ�����б�
		message.setUsernameList(userList) ;
		
		//��Message�����͵��ͻ���
		broadcast(sessionMap,message) ;
		
	}
	
	
	//�㲥 / ˽��
	/**
	 * ��ΪҪʵ����ϢȺ��,����Ҫ����map����,�õ����еĹܵ�
	 * Ȼ��ÿһ���ܵ�����Ϣ
	 * @param sessionMap
	 * @param message
	 */
	private void broadcast(Map<String,Session> sessionMap,Message message) {
		Gson gson = new Gson() ;
		String MessageJson = gson.toJson(message) ;
		for(Entry<String,Session> entry:sessionMap.entrySet()) {
			Session ses = entry.getValue() ;//�õ����еĹܵ�
			
			try {//��ÿһ���ܵ�������Ϣ
				ses.getBasicRemote().sendText(MessageJson) ;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@OnClose
	public void close(Session session) {
		/**
		 * Ϊ�˷�ֹsessionʧЧ��,����,����Ҫ��ʧЧ���Ƴ���Ӧ���û�
		 */
		
		sessionMap.remove(this.username) ;
		userList.remove(this.username) ;
		
		Message message = new Message() ;
		message.setInfo(this.username +" �뿪��������!") ;
		message.setUsernameList(userList) ;
		
		broadcast(sessionMap, message) ;
		
		
	}
	
	//��Ϣ�ķ��������,�ᴥ���������
	@OnMessage
	public void message(Session session,String msg,boolean flag) {
		//1.������Ϣ
		System.out.println(msg);
		
		
		//2.������Ϣ
		try {
			session.getBasicRemote().sendText("hello,world") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
