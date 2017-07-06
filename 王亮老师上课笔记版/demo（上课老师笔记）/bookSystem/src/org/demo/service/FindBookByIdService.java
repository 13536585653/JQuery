package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BTypeDao;
import org.demo.dao.BookDao;
import org.demo.entity.BType;

public class FindBookByIdService {
	//根据ID查询摸个书籍信息
	public Map<String,Object> findBook(int bid){
		//创建bookdao对象，查询书籍信息
		BookDao bookdao=new BookDao();
		Map<String,Object> map=bookdao.findBookById(bid);
		//创建BookTypeDao，查询所有的书籍类型
		BTypeDao btypedao=new BTypeDao();
		List<BType> list=btypedao.findType();
		//将书籍类型的list放入map集合
		map.put("list", list);
		return map;
	}
}
