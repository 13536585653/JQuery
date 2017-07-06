package com.test.servelt;

import java.util.List;

import com.test.bean.LoveInHeart;
import com.test.dao.LoveInHeartDao;

public class DeleteLoveService {
	public List<LoveInHeart> remove(String[] lids){
		LoveInHeartDao dao = new LoveInHeartDao();
		if(lids !=null && lids.length!=0){
			int[] bids = new int[lids.length];
			for(int i=0; i<bids.length; i++){
				//将字符串的每个id装换成int类型
				bids[i] = Integer.parseInt(lids[i]);
			}
		//业务处理完成后调用dao层进行删除操作
		dao.removeLove(bids);
		}
		return dao.all();
	}
}
