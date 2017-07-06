package org.order.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.order.bean.Backups;
import org.order.bean.Command;
import org.order.bean.PageBean2;
import org.order.dao.BackupsDao;



public class BackupsService {

	public int addDataBase(String str) {
		BackupsDao dao=new BackupsDao();
		Command c=new Command();
		//备份的路径
		int x=0;
		String url="E:\\DateBase\\";
		boolean n=c.backupDatebase("localhost","root","root", "school", url+str);
		if(n==true){
			x=dao.insert(str);
			
		}
		return x;
		
	}

	
	/**
	 * 
	 * 删除
	 * @param name
	 * @return
	 */
	public int  delete(String name) {
		BackupsDao dao=new BackupsDao();
		String str=name;
		String s = "E:\\DateBase\\"+str;
		int x=0;
		File file = new File(s);
		if (file.exists()) {
			boolean d = file.delete();
			if(d==true){
				x=dao.delete(name);
			}
		}
		return x;
	}


	
	/**
	 * 
	 * 还原
	 * @param name
	 * @return
	 */
	public boolean recover(String name) {

		String path="E://DateBase//"+name;
		System.out.println(path);
		String str="mysql -u root -proot school  <  "+path;
        // mysql命令可以实现数据库的还原。格式"mysql -u username  -ppassword   database_name     <     back_up_dir  "
        Runtime rt=Runtime.getRuntime();
        try {
			boolean d= rt.exec("cmd /c"+str) != null ;
			return d;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}


	public void selectbackups(PageBean2 pageBean2) {
		BackupsDao dao=new BackupsDao();
		int rowCount= dao.count();
		pageBean2.setRowCount(rowCount);
		List<Map<String,Object>> list = dao.selectbackups(pageBean2.getFirstResult(), pageBean2.getMaxResult()*pageBean2.getPageNum());
		pageBean2.setList(list);
		
	}

}
