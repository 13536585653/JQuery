package org.demo.service;

import java.util.List;
import java.util.Map;

import org.demo.dao.BTypeDao;
import org.demo.dao.BookDao;
import org.demo.entity.BType;

public class FindBookByIdService {
	//����ID��ѯ�����鼮��Ϣ
	public Map<String,Object> findBook(int bid){
		//����bookdao���󣬲�ѯ�鼮��Ϣ
		BookDao bookdao=new BookDao();
		Map<String,Object> map=bookdao.findBookById(bid);
		//����BookTypeDao����ѯ���е��鼮����
		BTypeDao btypedao=new BTypeDao();
		List<BType> list=btypedao.findType();
		//���鼮���͵�list����map����
		map.put("list", list);
		return map;
	}
}
