package dao;

import java.util.Random;

public class YZMCode {
	private final String letter="QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
	private Random rand = new Random();
	public String getYZM(){
		StringBuffer yzm = new StringBuffer();
		for(int i=0; i<4; i++){
			int t = rand.nextInt(letter.length());
			yzm.append(letter.charAt(t));
		}
		return yzm.toString();
	}
}
