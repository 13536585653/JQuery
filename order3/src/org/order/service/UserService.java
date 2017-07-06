package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.bean.PageBean2;
import org.order.bean.RoleBean;
import org.order.bean.UserBean;
import org.order.dao.MenuDao;
import org.order.dao.RoleDao;
import org.order.dao.UsersDao;
import org.order.dao.menbersDao;



public class UserService {

	public int[] delete(String[] s, String id) {
		UsersDao  dao=new UsersDao();
		if(s!=null && s.length!=0){
			int ids[]=new int[s.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i]=Integer.parseInt(s[i]);	
			}
				return dao.delete(ids);
		}
		return null;
	}

	public int delete1(int id1, int id2) {
		// TODO 自动生成的方法存根
		UsersDao dao=new UsersDao();
		menbersDao dao1=new menbersDao();
		if(id2==0){
			return dao.delete1(id1);
		}else{
			return dao1.delete1(id1);
		}
	}

	
	//查询指定的id的信息
	public Map<String, Object> selectById(int id) {
		UsersDao dao=new UsersDao();
		RoleDao r_dao=new RoleDao();
		Map<String,Object> map=dao.selectById(id);
		List<RoleBean> list=r_dao.select();
		map.put("list", list);
		return map;
	}

	
	//修改用户信息
	public int update(UserBean u) {
		UsersDao dao=new UsersDao();
		return dao.update(u);	

	}

	public Map<String, Object> selectmenberById(int ids) {
		 return selectById(ids);
	}

	//修改会员信息
	public int update2(UserBean u) {
		menbersDao dao=new menbersDao();
		return dao.update(u);

	}

	
	//查询用户的分页
	public void findUserList(PageBean2 pageBean2) {
		UsersDao dao=new UsersDao();

		int rowCount= dao.count();
		pageBean2.setRowCount(rowCount);
		List<Map<String,Object>> list = dao.findUserList(pageBean2.getFirstResult(), pageBean2.getMaxResult()*pageBean2.getPageNum());
		pageBean2.setList(list);
		
	}

	/**
	 * 
	 * 会员分页
	 * @param pageBean2
	 */
	public void findMenberList(PageBean2 pageBean2) {
		menbersDao dao=new menbersDao();
		int rowCount= dao.count();
		pageBean2.setRowCount(rowCount);
		List<Map<String,Object>> list = dao.findMenberList(pageBean2.getFirstResult(), pageBean2.getMaxResult()*pageBean2.getPageNum());
		pageBean2.setList(list);
		
	}

}
