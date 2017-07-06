package org.front.service;

import java.util.List;
import java.util.Map;

import org.front.dao.MenuDao;
import org.order.bean.PageBean;
public class SelectAllMenuService {

	public void selectallmenu(PageBean pageBean) {
		MenuDao dao=new MenuDao();
		int rowCount= dao.count();

		pageBean.setRowCount(rowCount);
		List<Map<String,Object>> list = dao.findBookList(pageBean.getFirstResult(), pageBean.getMaxResult());
		pageBean.setList(list);
	}

}
