package org.order.service;

import org.order.dao.JingxuanMenuDao;

public class DelJingxuanService {
	public int[] removejingxuan(String[] mmid){
		
		JingxuanMenuDao dao=new JingxuanMenuDao();
		
		if(mmid!=null&&mmid.length!=0){
			int[] ids=new int[mmid.length];
			for (int i = 0; i < ids.length; i++) {

				ids[i]=Integer.parseInt(mmid[i]);
				System.out.println(ids[i]);
			}
			return dao.removeJingxuan(ids);
		}
		return null;		
	}
}	
