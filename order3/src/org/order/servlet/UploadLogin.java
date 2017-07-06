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

@WebServlet("/admin/adminIndex/uploadfile2")
public class UploadLogin extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String uploadPath = request.getServletContext().getRealPath("order-index/img")+File.separator;

		DiskFileItemFactory factory = new DiskFileItemFactory();

		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			List<String> fileNames2 = getFileNames(request);
			for(FileItem item : list){	
				if(!item.isFormField()){
					
					String fileName = new File(item.getName()).getName();
					
					File file = new File(uploadPath+fileName);
					
					item.write(file);
					
					fileNames2.add(fileName);
				}
			}
			request.getSession().setAttribute("fileNames2", fileNames2);
			if(fileNames2!=null){
				for (String fileName : fileNames2) {
					
					request.getSession().setAttribute("fname", fileName);			
				}
				String fname = (String) request.getSession().getAttribute("fname");
				response.getWriter().println(fname);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<String> getFileNames(HttpServletRequest request){
		if(request.getSession().getAttribute("fileNames2") == null){
			request.getSession().setAttribute("fileNames2", new ArrayList<String>());
		}
		
		return (List<String>)request.getSession().getAttribute("fileNames2");
		
	}
}
