package demo.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.DormitoryDao;
import demo.entity.Dormitory;
import demo.utils.GsonUtil;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dormitoryId=request.getParameter("dormitoryId");
		String stuName=request.getParameter("stuName");
		String stuSex=request.getParameter("stuSex");
		String clsName=request.getParameter("clsName");
		String inDate=request.getParameter("inDate");
		Date date=Date.valueOf(inDate);
		String bN=request.getParameter("bedNo");
		int bedNo=Integer.parseInt(bN);
		
		Dormitory dormitory=new Dormitory();
		dormitory.setDormitoryId(dormitoryId);
		dormitory.setStuName(stuName);
		dormitory.setStuSex(stuSex);
		dormitory.setClsName(clsName);
		dormitory.setInDate(date);
		dormitory.setBedNo(bedNo);
		
		DormitoryDao dao=new DormitoryDao();
		boolean b1=dao.addUser(dormitory);
		String msg=b1==false?"登记成功":"登记失败";
		//String json=GsonUtil.toJson(msg, "yyyy-MM-dd");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(msg);
		System.out.println(msg);
	}
}
