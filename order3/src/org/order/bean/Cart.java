package org.order.bean;

public class Cart {

		/**
		 * 
		 * 购物车类
		 */
		private int m_id;
		private int num;
		private double price;
		public int getM_id() {
			return m_id;
		}
		public void setM_id(int m_id) {
			this.m_id = m_id;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		//数组
		public float select(int num[],float[] x){
			double result=0;
			float price[]=new float[x.length];
			for (int i = 0; i < x.length; i++) {
				price[i]=x[i];		
				result+=price[i]*num[i];	
			}	
			return (float) result;
			
		}
		
		public static void main(String[] args) {
			Cart c=new Cart();
			int n[]={1,2};//数量
			float x[]={2.4f,34.0f};//价格
			
			float xx=c.select(n, x);
			System.out.println(xx);
			
			
			
		}
		
}
