package org.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadfile")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取上传的目录
		String uploadPath = request.getServletContext().getRealPath("/upload")+File.separator;
		//创建文件工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//创建文件上传的助手，将工厂作为参数传递给这个助手
		ServletFileUpload upload = new ServletFileUpload(factory);
		//通过这个助手开始解析请求，因为请求中即有表单的文本内容，还有文件内容
		//返回的是一个文件列表
		try {
			List<FileItem> list = upload.parseRequest(request);
			//获取一个用于保存文件名的集合
			List<String> fileNames = getFileNames(request);
			//循环遍历文件列表，取出每一个FileItem
			for(FileItem item : list){	
				//最关键的地方，执行判断，判断是文本内容还是文件内容
				if(!item.isFormField()){
					String fileName = new File(item.getName()).getName();
					//结合上传路径和文件名构建一个文件对象
					File file = new File(uploadPath+fileName);
					//通过write方法写入到服务器中
					item.write(file);
					//将文件名保存起来
					fileNames.add(fileName);
				}
			}
			//将文件名暂时存放在session，后续表单提其他交数据时，一并保存到数据库
			request.getSession().setAttribute("fileNames", fileNames);
			response.getWriter().println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<String> getFileNames(HttpServletRequest request){
		if(request.getSession().getAttribute("fileNames") == null){
			request.getSession().setAttribute("fileNames", new ArrayList<String>());
		}
		return (List<String>)request.getSession().getAttribute("fileNames");
	}
}
