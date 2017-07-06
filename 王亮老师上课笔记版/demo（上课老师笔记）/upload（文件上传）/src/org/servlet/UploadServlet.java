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
		//��ȡ�ϴ���Ŀ¼
		String uploadPath = request.getServletContext().getRealPath("/upload")+File.separator;
		//�����ļ�����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//�����ļ��ϴ������֣���������Ϊ�������ݸ��������
		ServletFileUpload upload = new ServletFileUpload(factory);
		//ͨ��������ֿ�ʼ����������Ϊ�����м��б����ı����ݣ������ļ�����
		//���ص���һ���ļ��б�
		try {
			List<FileItem> list = upload.parseRequest(request);
			//��ȡһ�����ڱ����ļ����ļ���
			List<String> fileNames = getFileNames(request);
			//ѭ�������ļ��б�ȡ��ÿһ��FileItem
			for(FileItem item : list){	
				//��ؼ��ĵط���ִ���жϣ��ж����ı����ݻ����ļ�����
				if(!item.isFormField()){
					String fileName = new File(item.getName()).getName();
					//����ϴ�·�����ļ�������һ���ļ�����
					File file = new File(uploadPath+fileName);
					//ͨ��write����д�뵽��������
					item.write(file);
					//���ļ�����������
					fileNames.add(fileName);
				}
			}
			//���ļ�����ʱ�����session��������������������ʱ��һ�����浽���ݿ�
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
