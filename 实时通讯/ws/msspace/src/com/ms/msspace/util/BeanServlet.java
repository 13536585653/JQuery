package com.ms.msspace.util;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/***
 * BeanServlet用于做其他Servlet的父类
 * @author heima
 *
 */
public class BeanServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 处理响应时的编码
		 */
		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 获取客户端传递过来的参数调用不同的方法
		 * */
		String methodName = request.getParameter("method");
		
		/**
		 * 获取当前对象的Class对象,通过getMethod()方法获取当前对象所指定的方法,并传递相关的参数
		 */
		Method method= null;
			try {//可能找不到这个方法,所以要做异常处理
				method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			} catch (Exception e) {
				throw new RuntimeException() ;
			}
			
			/**
			*	通过method对象调用当前对象的方法
			*/
			try {
				String result = (String)method.invoke(this, request,response);
				/**
				 * 如果result不为空,说明存在这个方法
				 */
				if(result != null && !result.trim().isEmpty()){
					/**
					 * 当调用方法时,返回一个字符串,该字符串就是一个请求地址
					 * 
					 */
					
					int index = result.indexOf(":");//获取第一个冒号的位置
					if(index == -1) {//如果没有冒号，使用转发
						request.getRequestDispatcher(result).forward(request, response);
					} else {//如果存在冒号
						String start = result.substring(0,index);//分割出前缀
						String path = result.substring(index + 1);//分割出路径
						if(start.equals("F")) {//前缀为f表示转发
							request.getRequestDispatcher(path).forward(request, response);
						} else if(start.equals("R")) {//前缀为r表示重定向
							response.sendRedirect(request.getContextPath() + path);
						}
					}
				}
			} catch (Exception e) {
				throw new RuntimeException() ;
			}
	}
}
