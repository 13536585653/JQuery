package org.demo.service;

import org.demo.dao.UserDao;
import org.demo.entity.Users;

public class LoginService {
	/***
	 * У���û����˺��Ƿ���ȷ
	 */
	public boolean checkUser(String userName,String password){
		UserDao dao = new UserDao();
		Users user = dao.findUserByName(userName);
		System.out.println(user);
		//�����ѯ���û���Ϊ�գ���ô����֤�����Ƿ�һ��
		//�������룬ʹ����Ŀ�����������֤
		return (user!=null&&password.equals(user.getPassword()));
		}
		/*if(user!=null){
			if(password.equals(user.getPassword())){
				return true;
				}
			}
		//����û�Ϊ�գ��������벻һ�¶�����false
		return false;
	}*/
}
