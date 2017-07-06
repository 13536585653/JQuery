package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.bean.Menu;
import org.order.bean.PageBean2;
import org.order.dao.JingxuanMenuDao;
import org.order.dao.MenuDao;

public class FindMenuService {
	public void findBookList(PageBean2 pageBean2){
		MenuDao dao=new MenuDao();

		int rowCount= dao.count();
		pageBean2.setRowCount(rowCount);
		List<Map<String,Object>> list = dao.findBookList(pageBean2.getFirstResult(), pageBean2.getMaxResult()*pageBean2.getPageNum());
		pageBean2.setList(list);
		}

	
	
	//移除精选菜
	public int remove(Menu m) {
		JingxuanMenuDao dao=new JingxuanMenuDao();
		int n =dao.remove(m);
		return n;
	}
}
