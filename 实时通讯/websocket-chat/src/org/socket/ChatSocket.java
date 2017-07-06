package org.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.chat.entity.Message;

import com.google.gson.Gson;

@ServerEndpoint("/chatSocket")
public class ChatSocket {

	private String username;
	//private static List<Session> sessionList = new ArrayList<Session>();
	private static Map<String, Session> sessionMap = new HashMap<String, Session>();
	private static List<String> usernameList = new ArrayList<String>();

	public ChatSocket() {
		System.out.println("chatsocket....");
	}

	@OnOpen
	public void open(Session session) {
		String queryString = session.getQueryString();
		String username = queryString.substring(queryString.indexOf("=") + 1);

		this.username = username;
		//sessionList.add(session);
		sessionMap.put(this.username, session);
		usernameList.add(this.username);
		String info = "欢迎 " + this.username + " 进入聊天室!";

		Message message = new Message();
		message.setInfo(info);
		message.setUsernameList(usernameList);

		Gson gson = new Gson();
		String json = gson.toJson(message);

		broadcast(sessionMap, json);
		// System.out.println(json);
	}

	// 广播信息
	// public void broadcast(List<Session> sessionList, String msg) {
	// for (Session session : sessionList) {
	// try {
	// session.getBasicRemote().sendText(msg);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//receive message users
	private void broadcast(Map<String, Session> sessionMap, String msg) {

		for (Map.Entry<String, Session> entry : sessionMap.entrySet()) {
			Session session = entry.getValue() ;
			try {
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@OnClose
	public void close(Session session) {
		// 退出登录时提示信息
		String info = this.username + "退出聊天室!";

		// 移除session和登录用户
		//sessionList.remove(session);
		sessionMap.remove(this.username) ;
		usernameList.remove(this.username);

		// 封装信息
		Message message = new Message();
		message.setInfo(info);
		message.setUsernameList(usernameList);

		Gson gson = new Gson();
		String json = gson.toJson(message);

		// 广播信息
		broadcast(sessionMap, json);
	}

	@OnMessage
	public void sendMessage(Session session, String msg, boolean last) {

		Gson gson = new Gson();
		Message message = gson.fromJson(msg, Message.class);

		if (message.getType() == 1) {
			// 群聊
			message.setMessage(this.username, message.getMessage());
			message.setUsernameList(usernameList);
			String json = gson.toJson(message);
			broadcast(sessionMap, json);
		} else {
			// 私聊
			Session toSession = sessionMap.get(message.getTo());

			message.setMessage(this.username, message.getMessage());
			message.setUsernameList(usernameList);

			String json = gson.toJson(message);

			Map<String,Session> maps = new HashMap<String,Session>() ;
			maps.put(message.getTo(), toSession) ;
			maps.put(this.username,session);
			broadcast(maps, json);
		}

		System.out.println("->" + message);
	}
}
