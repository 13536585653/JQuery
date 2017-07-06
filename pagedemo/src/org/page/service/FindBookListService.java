package org.page.service;

import java.util.List;
import java.util.Map;

import org.page.dao.BookDao;
import org.page.utils.PageBean;

public class FindBookListService {
	public void findBookList(PageBean pageBean){
	BookDao dao=new BookDao();
	//1、先调用dao查询总记录数
	int rowCount= dao.count();
	//将rowCount传入给PageBean对象自动计算页数
	//setRowCount方法会自动换算出总页数
	pageBean.setRowCount(rowCount);
	//2 再调用dao查询分页记录
	List<Map<String,Object>> list = dao.findBookList(pageBean.getFirstResult(), pageBean.getMaxResult()*pageBean.getPageNum());
	//将list再封装到pageBean中
	pageBean.setList(list);
	}
}
