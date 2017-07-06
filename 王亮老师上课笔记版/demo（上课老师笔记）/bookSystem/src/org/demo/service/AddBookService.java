package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BookDao;
import org.demo.entity.Book;

public class AddBookService {
	public List<Map<String,Object>>addBook(Book book){
		//创建dao
		BookDao dao=new BookDao();
		//先保存书籍信息
		dao.save(book);
		//返回去查书籍
		return dao.findBooks();
	}
}
