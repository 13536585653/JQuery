package org.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.order.dao.MenuDao;


public class FindMenuByNameService {

	
	//妯＄硦鏌ヨ鑿�
	public List<Map<String,Object>> find(int m_id, String key) {
		MenuDao dao=new MenuDao();
		List<Object> params = new ArrayList<Object>();
		StringBuilder sql = new StringBuilder("select * from menu m left join dishes d on m.d_id=d.d_id where 1=1 ");
		if(m_id != 0){
			sql.append("and d.d_id = ? ");
			params.add(m_id);
		}
		if(key != null){
			sql.append("and m.m_name = ?");
			params.add(key);
		}
		return dao.find(sql.toString(), params);
	}

}
