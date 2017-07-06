package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.bean.Order;
import org.order.bean.PageBean;
import org.order.dao.OrderDao;

public class OrderService {

	
	//添加订单
	public int addorder(Order order) {
		OrderDao dao=new OrderDao();
		return dao.addOrder(order);		
	}
	
	//批量删除
	public int[] delete(String[] id) {
		OrderDao dao=new OrderDao();
		int ids[]=new int[id.length];
		for(int i=0;i<id.length;i++){
			ids[i]=Integer.parseInt(id[i]);
		}
		
		return dao.delete(ids);
		
	}
	
	//发货
	public int update(int id) {
		int state=2;
		OrderDao dao=new OrderDao();
		int n=dao.update(id,state);
		return n;

	}

	
	//分页查询所有订单
	public List<Map<String, Object>> selectorder(PageBean pageBean) {
		OrderDao dao=new OrderDao();
		int count=dao.count();
		pageBean.setRowCount(count);
		List<Map<String,Object>> list = dao.selectorder2(pageBean.getFirstResult(), pageBean.getMaxResult());
		pageBean.setList(list);
		return list;
	}

	
	/**
	 * 
	 * 取消订单
	 * @param id
	 * @return
	 */
	public int quxorder(int id) {
		OrderDao dao=new OrderDao();
		int n=dao.quxorder(id);
		return n;

	}

}
