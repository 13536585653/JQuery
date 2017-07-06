package org.page.service;

import java.util.List;
import java.util.Map;

import org.page.dao.BookDao;
import org.page.utils.PageBean;

public class FindBookListService {
	public void findBookList(PageBean pageBean){
	BookDao dao=new BookDao();
	//1���ȵ���dao��ѯ�ܼ�¼��
	int rowCount= dao.count();
	//��rowCount�����PageBean�����Զ�����ҳ��
	//setRowCount�������Զ��������ҳ��
	pageBean.setRowCount(rowCount);
	//2 �ٵ���dao��ѯ��ҳ��¼
	List<Map<String,Object>> list = dao.findBookList(pageBean.getFirstResult(), pageBean.getMaxResult()*pageBean.getPageNum());
	//��list�ٷ�װ��pageBean��
	pageBean.setList(list);
	}
}
