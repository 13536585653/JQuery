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
				//��ÿһ���ַ�����idת����int���ͣ�������int������
				ids[i]=Integer.parseInt(mmid[i]);
				System.out.println(ids[i]);
			}
			//ת�����֮�󣬵���ִ��ɾ��
			dao.removeHelp(ids);
		}
		return dao.FindWenti();
	}
}
