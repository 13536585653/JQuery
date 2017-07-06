package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.bean.Dishes;
import org.order.bean.PageBean2;
import org.order.dao.DishesDao;



/**
 * 
 * ��Ʒ �����service
 * 
 * @author LIANG
 *
 */
public class DishesService {

	public int addDishes(Dishes d) {
		DishesDao dao=new DishesDao();
		if(dao.finddishes(d)!=null){
			return 0;
		}
		else{
			return dao.adddisher(d);
		}
		
		}


	// 批量删除
	public int[] delete(String[] id) {
		DishesDao dao = new DishesDao();
		if (id != null && id.length != 0) {
			int ids[] = new int[id.length];
			for (int i = 0; i < ids.length; i++) {
				ids[i] = Integer.parseInt(id[i]);
			}
			return dao.delete(ids);
		}

		return null;
	}

	public int delete1(int id1) {
		DishesDao dao = new DishesDao();
		return dao.delete1(id1);
	}


	public List<Dishes> selectDishes() {
		DishesDao dao = new DishesDao();
		return dao.selectdishes();
	}


	public void findDishesList(PageBean2 pageBean2) {
		DishesDao dao=new DishesDao();
		int rowCount= dao.count();
		pageBean2.setRowCount(rowCount);
		List<Map<String,Object>> list = dao.findDishesList(pageBean2.getFirstResult(), pageBean2.getMaxResult()*pageBean2.getPageNum());
		pageBean2.setList(list);
		
	}

}
