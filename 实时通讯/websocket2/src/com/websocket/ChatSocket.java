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
 * @author Administrator
 *
 */

@ServerEndpoint("/chat")
public class ChatSocket {
	
	//当前登录的用户
	private String username ;
	
	//把所有的Session收集在Map集合中
	/**
	 * 为了实现信息群发/私发做准备
	 * Map集合中的String是用户的名称
	 * Map集合中的Session是用户的通讯管道
	 * 
	 * 这里为什么要用户名作为键,因为到时候通过这个键,找到相对应的管道进行私聊
	 */
	private static Map<String,Session> sessionMap = new HashMap<String,Session>() ;
	
	//用户列表
	private static List<String> userList = new ArrayList<String>() ;
	

	@OnOpen
	public void open(Session session) {//当前管道的会话
		//System.out.println("chat Socket打开连接了");
		//获取客户端传递过来的参数
		String queryString = session.getQueryString() ;
		//System.out.println("-->"+queryString);
		
		//this.username = queryString.substring(queryString.charAt('=')+1,queryString.length()) ;
		this.username = queryString.split("=")[1] ;
		sessionMap.put(this.username, session) ;//把当前登录的所有用户和相对应的管道都添加到Map集合中
		
		userList.add(this.username) ;//把用户添加到用户列表
		
		//把要响应的数据封装到Message对象中
		Message message = new Message() ;
		
		message.setInfo("欢迎 " + this.username + " 进入聊天室") ;
		
		//为了在每一个用户的界面都显示好友列表
		message.setUsernameList(userList) ;
		
		//把Message对象发送到客户端
		broadcast(sessionMap,message) ;
		
	}
	
	
	//广播 / 私聊
	/**
	 * 因为要实现信息群发,所有要遍历map集合,得到所有的管道
	 * 然向每一个管道发信息
	 * @param sessionMap
	 * @param message
	 */
	private void broadcast(Map<String,Session> sessionMap,Message message) {
		Gson gson = new Gson() ;
		String MessageJson = gson.toJson(message) ;
		for(Entry<String,Session> entry:sessionMap.entrySet()) {
			Session ses = entry.getValue() ;//得到所有的管道
			
			try {//给每一个管道发送信息
				ses.getBasicRemote().sendText(MessageJson) ;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@OnClose
	public void close(Session session) {
		/**
		 * 为了防止session失效了,报错,所有要在失效是移除相应的用户
		 */
		
		sessionMap.remove(this.username) ;
		userList.remove(this.username) ;
		
		Message message = new Message() ;
		message.setInfo(this.username +" 离开了聊天室!") ;
		message.setUsernameList(userList) ;
		
		broadcast(sessionMap, message) ;
		
		
	}
	
	//消息的发送与接收,会触发这个方法
	@OnMessage
	public void message(Session session,String msg,boolean flag) {
		//1.接收消息
		System.out.println(msg);
		
		
		//2.发送消息
		try {
			session.getBasicRemote().sendText("hello,world") ;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
