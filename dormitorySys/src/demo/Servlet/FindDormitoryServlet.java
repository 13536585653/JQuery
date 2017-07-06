package demo.Servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.dao.DormitoryDao;
import demo.utils.GsonUtil;
@WebServlet("/findDormitoryServlet")
public class FindDormitoryServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		System.out.println("≤È’“÷–°£°£°£°£");
		DormitoryDao dao=new DormitoryDao();
		List<Map<String,Object>>list=dao.findDormitory();
		String json=GsonUtil.toJson(list,"yyyy-MM-dd");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().println(json);
	}
}
