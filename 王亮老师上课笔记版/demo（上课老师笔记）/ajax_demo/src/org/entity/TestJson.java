package org.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestJson {

	public static void main(String[] args) {
		UserBean u1 = new UserBean();
		u1.setUserName("user1");
		u1.setAge(21);
		UserBean u2 = new UserBean();
		u2.setUserName("user2");
		u2.setAge(31);
		List<UserBean> list = new ArrayList<UserBean>();
		list.add(u1);
		list.add(u2);
		//将对象转换成json字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
	}
}
