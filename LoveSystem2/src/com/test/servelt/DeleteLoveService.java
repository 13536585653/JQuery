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
				//���ַ�����ÿ��idװ����int����
				bids[i] = Integer.parseInt(lids[i]);
			}
		//ҵ������ɺ����dao�����ɾ������
		dao.removeLove(bids);
		}
		return dao.all();
	}
}
