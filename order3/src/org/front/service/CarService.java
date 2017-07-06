package org.front.service;

import org.front.dao.CarDao;
import org.order.bean.MyCat;

public class CarService {

	public int check(MyCat c) {
		CarDao dao=new CarDao();
		int n=dao.check(c);
		if(n>0){
			return dao.updatecar(c);
		}else{
			return dao.addcar(c);
		}
	}

}
