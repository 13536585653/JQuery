package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BookDao;
import org.demo.entity.Book;

public class AddBookService {
	public List<Map<String,Object>>addBook(Book book){
		//����dao
		BookDao dao=new BookDao();
		//�ȱ����鼮��Ϣ
		dao.save(book);
		//����ȥ���鼮
		return dao.findBooks();
	}
}
