package com.config;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 * �ڶ�������WebSocket�ĺ��������� ������Ŀ����ʱ�Զ�ִ�У���ContextListener���ƣ��� ������������ʱ����ɨ�����е�Endpoint��
 * ����ӵ�set�����У������ء�
 * 
 * @author Administrator
 * 
 */
public class DemoConfig implements ServerApplicationConfig {

	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
		System.out.println("ServerApplicationConfig������!");
		System.out.println("Endpoint�����������" + set.size());
		// ��set���Ͻ��й���...

		return set;
	}

	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(
			Set<Class<? extends Endpoint>> s) {
		return null;
	}

}
