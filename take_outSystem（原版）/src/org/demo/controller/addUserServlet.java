package org.demo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.dao.UserDao;
import org.demo.entity.RoleBean;
import org.demo.entity.UserBean;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/addUser")
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
		//��ȡ���ύ����֤��
		String yzm=request.getParameter("yzm");
		System.out.println("��֤�룺"+yzm);
		//�õ���������֤��
		String realYzm=(String) request.getSession().getAttribute("yzm");
		if(realYzm.equals(yzm)){
			//���ձ��ύ����Ϣ
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
				String msg=i==0?"ע��ʧ��":"ע��ɹ�";
				request.setAttribute("message", msg);
				//�յ��û��ύ����֤��
				System.out.println(msg);
			}
			response.sendRedirect("HTML/addUser.jsp");
		}else{
			System.out.println("��֤�벻��ȷ");
			request.setAttribute("msg", "�����֤�벻��ȷ��");
			response.sendRedirect("HTML/addUser.jsp");
			//request.getRequestDispatcher("HTML/addUser.jsp").forward(request, response);
		}
		
		
	}
}
