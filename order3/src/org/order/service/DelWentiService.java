package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.dao.HelpWentiDao;

public class DelWentiService {
	public List<Map<String,Object>> removeWenti(String[] mmid){
		
		HelpWentiDao dao=new HelpWentiDao();
		
		if(mmid!=null&&mmid.length!=0){
			int[] ids=new int[mmid.length];
			for (int i = 0; i < ids.length; i++) {
				//将每一个字符串的id转换成int类型，保存在int数组中
				ids[i]=Integer.parseInt(mmid[i]);
				System.out.println(ids[i]);
			}
			//转换完成之后，调用执行删除
			dao.removeHelp(ids);
		}
		return dao.FindWenti();
	}
}
