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
 * 实现在线聊天
 * 
 * @author Administrator
 * 
 */

@ServerEndpoint("/chat")
public class ChatSocket {

	// 当前登录的用户
	private String username;

	// 把所有的Session收集在Map集合中
	private static Map<String, Session> sessionMap = new HashMap<String, Session>();

	// 用户列表
	private static List<String> userList = new ArrayList<String>();

	@OnOpen
	public void open(Session session) {
		// System.out.println("chat Socket打开连接了");
		String queryString = session.getQueryString();
	
		// queryString.substring(queryString.charAt('=')+1,queryString.length())
		// ;
		this.username = queryString.split("=")[1];//返回一个字符串数组,分成两个部分,取等号右边的值
		
		sessionMap.put(this.username, session);
		userList.add(this.username);

		Message message = new Message();
		message.setInfo("欢迎 " + this.username + " 进入聊天室");//提示的信息
		message.setUsernameList(userList);	//好友在线列表

		
		//System.out.println(userList.size());
		
		/*把Message对象发送到客户端,把整一个Map集合发过去,只有一个目的,那么就是
			为了告诉好友们,他上线了,message对象在这里是提示信息
		*/
		broadcast(sessionMap, message);

	}

	// 广播 / 私聊
	private void broadcast(Map<String, Session> sessionMap, Message message) {
		Gson gson = new Gson();
		String messageJson = gson.toJson(message);//把一个对象转换为一个json格式的字符串
		
		//System.out.println(messageJson);
		
		//遍历Map集合,得到所有的通讯管道
		for (Entry<String, Session> entry : sessionMap.entrySet()) {
			Session ses = entry.getValue();
				//System.out.println(ses+"==");
			try {//把消息发送到客户端浏览器中
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
		message.setInfo(this.username + " 离开了聊天室!");
		message.setUsernameList(userList);

		broadcast(sessionMap, message);

	}

	@OnMessage
	public void message(Session session, String msg, boolean flag) {
		// 1.接收消息
		//System.out.println("=>" + msg);

		// 把客户端发送过来的json字符串，转换为对应的对象
		Gson gson = new Gson();
		Message message = gson.fromJson(msg, Message.class);
		//System.out.println(message);
		//System.out.println("-->"+message.getUsernameList());
		message.setUsernameList(userList) ;
		
		// 私聊
		if (message.getType() == 2) {
			/**
			 * 这里为什么要重新new一个Map集合呢?是因为这里不能把向所有的通道发送信息了
			 * 所以要创建一个集合,要来保存私聊的管道
			 */
			Map<String, Session> map = new HashMap<String, Session>();
			// 当前用户
			map.put(this.username, sessionMap.get(this.username));//发送者
			// 私聊用户
			map.put(message.getTo(), sessionMap.get(message.getTo()));//接收者

			// 2.发送消息
			
			/**
			 * message是发送者发送过来的整一条信息
			 * map是实现私聊的管道
			 */
			broadcast(map, message);

		} else {
			// 2.发送消息
			// 群聊
			broadcast(sessionMap, message);
		}

	}

}
