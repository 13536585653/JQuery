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
					//��ÿһ���ַ�����idת����int���ͣ�������int������
					ids[i]=Integer.parseInt(mids[i]);
				}
				//ת�����֮�󣬵���ִ��ɾ��
				dao.removeHelp(ids);
			}
			return dao.findHelpType();
		}
	}

	

