package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.dao.HelpTypeDao;

public class DelService {
	

		public List<Map<String,Object>> removeMenus(String[] mids){
			
			HelpTypeDao dao=new HelpTypeDao();
			
			if(mids!=null&&mids.length!=0){
				int[] ids=new int[mids.length];
				for (int i = 0; i < ids.length; i++) {
					//将每一个字符串的id转换成int类型，保存在int数组中
					ids[i]=Integer.parseInt(mids[i]);
				}
				//转换完成之后，调用执行删除
				dao.removeHelp(ids);
			}
			return dao.findHelpType();
		}
	}

	

