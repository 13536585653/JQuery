package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.bean.PageBean;
import org.order.dao.HelpWentiDao;


public class FindWentiService {
	public void findBookList(PageBean pageBean){
	HelpWentiDao dao=new HelpWentiDao();
	//1���ȵ���dao��ѯ�ܼ�¼��
	int rowCount= dao.count();
//System.out.println(rowCount);
	//��rowCount�����PageBean�����Զ�����ҳ��
	//setRowCount�������Զ��������ҳ��
	pageBean.setRowCount(rowCount);
	//2 �ٵ���dao��ѯ��ҳ��¼
	List<Map<String,Object>> list = dao.findBookList(pageBean.getFirstResult(), pageBean.getMaxResult()*pageBean.getPageNum());
	//��list�ٷ�װ��pageBean��
	pageBean.setList(list);
	}
}
