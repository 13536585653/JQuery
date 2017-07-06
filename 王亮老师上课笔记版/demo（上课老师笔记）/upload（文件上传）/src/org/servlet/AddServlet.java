package org.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//接收表单数据
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		System.out.println(userName);
		System.out.println(passwd);
		//从会话中获取之前保存的文件名
		List<String> fileNames = (List<String>)request.getSession().getAttribute("fileNames");
		for (String fileName : fileNames) {
			System.out.println(fileName);
		}
		//将所有信息一并保存到数据库，调用dao执行...
		response.sendRedirect("index.html");
	}
}
