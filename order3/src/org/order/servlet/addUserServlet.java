package org.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.order.bean.RoleBean;
import org.order.bean.UserBean;
import org.order.dao.UserDao;



/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/order-index/register")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @return 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�?�ύ����֤��
		String yzm=request.getParameter("yzm");
		System.out.println("验证码："+yzm);
		//�õ��������֤��
		String realYzm=(String) request.getSession().getAttribute("yzm");
		if(realYzm.equals(yzm)){
			//���ձ?�ύ����Ϣ
			/*UserBean user=BeanUtil.toBean(request.getParameterMap(), UserBean.class);*/
			String uname=request.getParameter("uname");
			String upwd=request.getParameter("upwd");
			String usex=request.getParameter("usex");
			String uaddr=request.getParameter("uaddr");
			String uemail=request.getParameter("uemail");
			String utel=request.getParameter("utel");
			int rtype=1;
			UserBean user =new UserBean();
			user.setUname(uname);
			user.setUpwd(upwd);
			user.setUsex(usex);
			user.setUaddr(uaddr);
			user.setUemail(uemail);
			user.setUtel(utel);
			user.setUmonetary(0);
			RoleBean role=new RoleBean();
			role.setRid(rtype);;
			user.setRtype(role);
			UserDao dao=new UserDao();
			UserBean newUser=dao.findUserByName(user);
			if(newUser==null){
				int i=dao.addUser(user);
				String json = i==0 ? "注册失败":"注册成功";
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(json);
				}
		}else{
			System.out.println("验证码输入错误！");
			//request.setAttribute("msg", "�����֤�벻��ȷ��");
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().println("验证码输入错误！");
			//request.getRequestDispatcher("HTML/addUser.jsp").forward(request, response);
		}
		
	}
}
