package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BookDao;
import org.demo.entity.Book;

public class UpdateBookService {
	public List<Map<String,Object>> update(Book book){
		//创建dao
		BookDao dao=new BookDao();
		//先执行更新
		dao.updateBook(book);
		//查询最新的数据列表
		return dao.findBooks();
	}
}
