package org.order.servlet;

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

@WebServlet("/admin/adminIndex/uploadfile")
public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uploadPath = request.getServletContext().getRealPath("/admin/adminIndex/images")+File.separator;

		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			List<String> fileNames = getFileNames(request);
			for(FileItem item : list){	
				if(!item.isFormField()){
					
					String fileName = new File(item.getName()).getName();
					
					File file = new File(uploadPath+fileName);
					
					item.write(file);
					
					fileNames.add(fileName);
				}
			}
			request.getSession().setAttribute("fileNames", fileNames);
			response.getWriter().println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<String> getFileNames(HttpServletRequest request){
		if(request.getSession().getAttribute("fileNames") == null){
			request.getSession().setAttribute("fileNames", new ArrayList<String>());
		}
		return (List<String>)request.getSession().getAttribute("fileNames");
	}
}
