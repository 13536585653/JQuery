package org.order.bean;

public class HelpWenti {
		private int w_id;
		private String w_wenti;
		private String w_daan;
		private HelpType type;
		public int getW_id() {
			return w_id;
		}
		public void setW_id(int w_id) {
			this.w_id = w_id;
		}
		public String getW_wenti() {
			return w_wenti;
		}
		public void setW_wenti(String w_wenti) {
			this.w_wenti = w_wenti;
		}
		public String getW_daan() {
			return w_daan;
		}
		public void setW_daan(String w_daan) {
			this.w_daan = w_daan;
		}
		public HelpType getType() {
			return type;
		}
		public void setType(HelpType type) {
			this.type = type;
		}
		public HelpWenti() {
			super();
			// TODO 自动生成的构造函数存根
		}
		public HelpWenti(int w_id, String w_wenti, String w_daan, HelpType type) {
			super();
			this.w_id = w_id;
			this.w_wenti = w_wenti;
			this.w_daan = w_daan;
			this.type = type;
		}
		
		
		
}
