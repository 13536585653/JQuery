package com.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 第二：定义WebSocket的核心配置类 会在项目启动时自动执行（与ContextListener相似）， 在启动服务器时，会扫描所有的Endpoint，
 * 并添加到set集合中，并返回。
 * 
 * @author Administrator
 * 
 */
public class DemoConfig implements ServerApplicationConfig {

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
		System.out.println("ServerApplicationConfig启动了!");
		System.out.println("Endpoint程序的数量：" + set.size());
		// 对set集合进行过滤...

		return set;
	}

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(
			Set<Class<? extends Endpoint>> s) {
		return null;
	}

}
