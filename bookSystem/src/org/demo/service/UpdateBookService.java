package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BookDao;
import org.demo.entity.Book;

public class UpdateBookService {
	public List<Map<String,Object>> update(Book book){
		//����dao
		BookDao dao=new BookDao();
		//��ִ�и���
		dao.updateBook(book);
		//��ѯ���µ������б�
		return dao.findBooks();
	}
}
