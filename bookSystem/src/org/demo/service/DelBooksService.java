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
				//将每一个字符串的id转换成int类型，保存在int数组中
				ids[i]=Integer.parseInt(bids[i]);
			}
			//转换完成之后，调用执行删除
			dao.removeBooks(ids);
			
		}
		return dao.findBooks();
	}
}
		

