package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BookDao;
public class DelBooksService {
	public List<Map<String,Object>> removeBooks(String[] bids){
		BookDao dao=new BookDao();
		if(bids!=null&&bids.length!=0){
			int[] ids=new int[bids.length];
			for (int i = 0; i < ids.length; i++) {
				//��ÿһ���ַ�����idת����int���ͣ�������int������
				ids[i]=Integer.parseInt(bids[i]);
			}
			//ת�����֮�󣬵���ִ��ɾ��
			dao.removeBooks(ids);
			
		}
		return dao.findBooks();
	}
}
		

