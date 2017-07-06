package org.order.service;

import java.util.List;
import java.util.Map;

import org.order.bean.PageBean;
import org.order.bean.PageBean2;
import org.order.dao.JingxuanMenuDao;

public class FindJingxuanService {
	public void findJingxuan(PageBean pageBean){
		JingxuanMenuDao dao=new JingxuanMenuDao();
		//1���ȵ���dao��ѯ�ܼ�¼��
		int rowCount= dao.count();
	//System.out.println(rowCount);
		//��rowCount�����PageBean�����Զ�����ҳ��
		//setRowCount�������Զ��������ҳ��
		pageBean.setRowCount(rowCount);
		//2 �ٵ���dao��ѯ��ҳ��¼
		List<Map<String,Object>> list = dao.findBookList(pageBean.getFirstResult(), pageBean.getMaxResult());
		//��list�ٷ�װ��pageBean��
		pageBean.setList(list);
		//System.out.println(list);
		}
}
