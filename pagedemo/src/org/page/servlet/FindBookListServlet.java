package org.page.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.page.service.FindBookListService;
import org.page.utils.GsonUtil;
import org.page.utils.PageBean;

/**
 * Servlet implementation class FindBookListServlet
 */
@WebServlet("/findBooks")
public class FindBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接受表单传递过来的当前页数
		int pageNum =Integer.parseInt(request.getParameter("pageNum"));
		PageBean pageBean=new PageBean();
		pageBean.setPageNum(pageNum);
		//创建业务层进行业务 处理,同时将pageBean交给业务层进行封装计算
		FindBookListService service=new FindBookListService();
		service.findBookList(pageBean);
		//当业务处理完之后,pageBean就会封装好所有的分页信息和结果集
		//只需要将整个pageBean序列化成json字符串即可
		response.setContentType("application/json;charset=utf-8");
		String json=GsonUtil.toJson(pageBean,"yyyy-MM-dd");
		response.getWriter().println(json);
	}

}
