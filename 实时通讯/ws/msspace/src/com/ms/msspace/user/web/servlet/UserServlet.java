package com.ms.msspace.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ms.msspace.factory.MsspaceFactory;
import com.ms.msspace.user.entity.Users;
import com.ms.msspace.user.service.dao.UserServiceDao;
import com.ms.msspace.util.BeanServlet;
import com.ms.msspace.util.BeanUtil;
import com.ms.msspace.util.UuidUtils;

/**
 * 处理用户的所有请求
 */
@WebServlet("/UserInfor")
public class UserServlet extends BeanServlet{

	//调用业务层
	private UserServiceDao dao = MsspaceFactory.getUserServiceDaoImpl();
	
	/**
	 * 注册功能
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.获取注册表单中传递过来的数据
		 * 2.封装数据
		 * 3.进行合法性验证
		 * 4.调用service业务处理
		 * 5.把数据添加到数据库
		 */
		/*
		 * 从请求中获取表单中的d数据,并封装到Users实体中
		 */
		Users user = BeanUtil.toBean(request.getParameterMap(), Users.class);
		
		/**
		 * 用户的id编号
		 */
		user.setUser_ID(UuidUtils.uuid());
		
		//调用serviceDao处理业务
		dao.register(user);
		
		//验证码
		String checkcode_session = (String)request.getSession().getAttribute("checkcode_session");
		String checkcoed = request.getParameter("checkcoed");
		
		String path = "F:admin/login.jsp" ;
		
		if(!(checkcode_session.equals(checkcoed)) || checkcoed==null || checkcoed.trim().isEmpty()){
			path = "R:admin/register.jsp" ;
		}
		return path ;
	}
	
	//验证该用户是否已经存在
	public void checkName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		
		//调用dao处理业务
		
		//Gson gson = new Gson() ;
		response.getWriter().print(username);
      
		return ;
		
	}
}
	//int r = dao.isExistUser(username);
		//if(r==1){
			//
		//	String name = gson.toJson(username);
			
					//}
	//}


