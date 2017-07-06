package org.order.service;

import org.order.bean.Admin;
import org.order.dao.AdminDao;

public class AdminService {

	public Admin checkAdmin(Admin admin){
	AdminDao dao = new AdminDao();
	Admin newAdmin = dao.findAdmin(admin);
	if(newAdmin != null){
		//У���û�������
		if(admin.getPwd().equals(newAdmin.getPwd())){
			return admin;
		}
	}
	return null;
	}
}
