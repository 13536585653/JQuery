package org.order.service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.order.bean.Dishes;
import org.order.bean.Menu;
import org.order.bean.Test;
import org.order.dao.DishesDao;
import org.order.dao.MenuDao;




/**
 * 
 * 判断是否存在该菜
 * @author LIANG
 *
 */
public class MenuService {

	public int checkMenu(Menu menu) {
		MenuDao dao=new MenuDao();
		if(dao.check(menu)!=null){
			return 0;
		}
		else{
			
			return dao.addmenu(menu);
		}
		
	}

	/**
	 * 
	 * 批量删除
	 * @param id
	 * @return
	 */
	public int[] deletemenu(String[] id) {
		MenuDao dao=new MenuDao();
		if(id.length!=0&&id!=null){
			int ids[]=new int[id.length];
			for(int i=0;i<id.length;i++){
				ids[i]=Integer.parseInt(id[i]);
			}
			dao.deletemenu(ids);
		}
		return null;

	}

	
	//删除指定id的菜单
	public int  delete1(int id1) {
		MenuDao dao=new MenuDao();
		return dao.delete1(id1);
	}

	
	//查询指定id的菜单的信息
	public Map<String, Object> select(int ids) {
		MenuDao dao=new MenuDao();
		DishesDao d_dao=new DishesDao();
		Map<String,Object> map=dao.select(ids);
		List<Dishes> list=d_dao.selectdishes();
		map.put("list",list);
		return map;
	}

	public int update(Menu menu) {
		MenuDao dao=new MenuDao();
		int n=0;
		if(menu.getM_img()!=null){
			n=dao.update(menu);
		}else{
			n=dao.update1(menu);
		}
		return n;
		
	}

	
	
	public Map<String, Object>  selectById(int id,int num,float s) {
		MenuDao dao=new MenuDao();
		Map<String,Object> map=dao.selectById(id,num);
		Test t1=new Test();
		DecimalFormat fnum = new DecimalFormat("##0.00"); 
		float n=(float) t1.getTotal(map, num,s);
		String sum=fnum.format(n); 
		float d=(float) Double.parseDouble(map.get("m_price").toString());
		float jianm=(float)(num*d)-n;
		String dd=fnum.format(jianm); 
		map.put("sum", sum);
		map.put("jm", dd);
		return map;
	
	}
	
	public Menu selectById2(int id ,int num){
		MenuDao dao=new MenuDao();
		Menu map=dao.selectById2(id,num);
		Test t=new Test();
		t.getTotal(map);
		return map;
		
		
		
	}
	
	
/*	public static void main(String[] args) {
		MenuDao dao=new MenuDao();

		

		Map<String,Object> map1=dao.selectById(30,2);
		Test t1=new Test();
		double n=t1.getTotal(map1, 3);
		System.out.println(n);
	}*/



}
