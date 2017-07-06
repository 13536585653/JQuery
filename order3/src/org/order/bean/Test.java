package org.order.bean;

import java.util.Map;

public class Test {
		private int num;
		private float price;
		private double s;
		private double sum;
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public double getS() {
			return s;
		}
		public void setS(double d) {
			this.s = d;
		}
		public double getSum() {
			return sum;
		}
		public void setSum(float sum) {
			this.sum = sum;
		}
		
		public double getTotal(){
			double result=0;
			result=sum=num*price*s;
			System.out.println(result);
			return result;
			
			
		}
		public float getTotal(Map<String, Object> map, int num2,float s) {
			float result=0;
			float d=(float) Double.parseDouble(map.get("m_price").toString());
			result=(float) (sum=num2*s*d);
			return (float) result;
		}
		public double getTotal(Menu map) {
			double result=0;
			result=sum=map.getM_price()*map.getNum()*0.9;
			System.out.println(result);
			return result;
				
		}
		
}
