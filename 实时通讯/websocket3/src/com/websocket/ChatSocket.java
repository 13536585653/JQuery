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
 * 
 * @author Administrator
 * 
 */

@ServerEndpoint("/chat")
public class ChatSocket {

	// ��ǰ��¼���û�
	private String username;

	// �����е�Session�ռ���Map������
	private static Map<String, Session> sessionMap = new HashMap<String, Session>();

	// �û��б�
	private static List<String> userList = new ArrayList<String>();

	@OnOpen
	public void open(Session session) {
		// System.out.println("chat Socket��������");
		String queryString = session.getQueryString();
	
		// queryString.substring(queryString.charAt('=')+1,queryString.length())
		// ;
		this.username = queryString.split("=")[1];//����һ���ַ�������,�ֳ���������,ȡ�Ⱥ��ұߵ�ֵ
		
		sessionMap.put(this.username, session);
		userList.add(this.username);

		Message message = new Message();
		message.setInfo("��ӭ " + this.username + " ����������");//��ʾ����Ϣ
		message.setUsernameList(userList);	//���������б�

		
		//System.out.println(userList.size());
		
		/*��Message�����͵��ͻ���,����һ��Map���Ϸ���ȥ,ֻ��һ��Ŀ��,��ô����
			Ϊ�˸��ߺ�����,��������,message��������������ʾ��Ϣ
		*/
		broadcast(sessionMap, message);

	}

	// �㲥 / ˽��
	private void broadcast(Map<String, Session> sessionMap, Message message) {
		Gson gson = new Gson();
		String messageJson = gson.toJson(message);//��һ������ת��Ϊһ��json��ʽ���ַ���
		
		//System.out.println(messageJson);
		
		//����Map����,�õ����е�ͨѶ�ܵ�
		for (Entry<String, Session> entry : sessionMap.entrySet()) {
			Session ses = entry.getValue();
				//System.out.println(ses+"==");
			try {//����Ϣ���͵��ͻ����������
				ses.getBasicRemote().sendText(messageJson);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	@OnClose
	public void close(Session session) {

		sessionMap.remove(this.username);
		userList.remove(this.username);

		Message message = new Message();
		message.setInfo(this.username + " �뿪��������!");
		message.setUsernameList(userList);

		broadcast(sessionMap, message);

	}

	@OnMessage
	public void message(Session session, String msg, boolean flag) {
		// 1.������Ϣ
		//System.out.println("=>" + msg);

		// �ѿͻ��˷��͹�����json�ַ�����ת��Ϊ��Ӧ�Ķ���
		Gson gson = new Gson();
		Message message = gson.fromJson(msg, Message.class);
		//System.out.println(message);
		//System.out.println("-->"+message.getUsernameList());
		message.setUsernameList(userList) ;
		
		// ˽��
		if (message.getType() == 2) {
			/**
			 * ����ΪʲôҪ����newһ��Map������?����Ϊ���ﲻ�ܰ������е�ͨ��������Ϣ��
			 * ����Ҫ����һ������,Ҫ������˽�ĵĹܵ�
			 */
			Map<String, Session> map = new HashMap<String, Session>();
			// ��ǰ�û�
			map.put(this.username, sessionMap.get(this.username));//������
			// ˽���û�
			map.put(message.getTo(), sessionMap.get(message.getTo()));//������

			// 2.������Ϣ
			
			/**
			 * message�Ƿ����߷��͹�������һ����Ϣ
			 * map��ʵ��˽�ĵĹܵ�
			 */
			broadcast(map, message);

		} else {
			// 2.������Ϣ
			// Ⱥ��
			broadcast(sessionMap, message);
		}

	}

}
