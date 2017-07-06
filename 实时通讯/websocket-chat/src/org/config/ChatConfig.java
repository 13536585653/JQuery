package org.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
//实现ServerApplicationConfig接口的类，会在项目启动时自动执行（与ContextListener相似）
//ServerApplicationConfig是WebSocket的核心配置类,提供了以下两各种方法启动
public class ChatConfig implements ServerApplicationConfig {

	/**
	 * 1.注解方式的启动
	 * getAnnotatedEndpointClasses:扫描src下面所有的类，并把具有@ServerEndPoint注解的类添加到set集合中
	 * 具有@ServerEndPoint注解的类就是一个Endpoint,它是一个Websocke的一个服务器程序
	 */
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
		System.out.println("ServerApplicationConfig启动了....");
		System.out.println("Endpoint的数量："+set.size());
		//在启动服务器时，会扫描所有的Endpoint，并添加到set集合中，并返回;
		//同时，在返回之前可以对set集合进行处理（过滤）
		return set;
	}

	/**
	 * 2.接口方式的启动
	 */
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		return null;
	}

}
