package org.order.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Backups {
		private int b_id;
		private Timestamp b_time;
		private String b_name;
		public int getB_id() {
			return b_id;
		}
		public void setB_id(int b_id) {
			this.b_id = b_id;
		}
		public Timestamp getB_time() {
			return b_time;
		}
		public void setB_time(Timestamp timestamp) {
			this.b_time = timestamp;
		}
		public String getB_name() {
			return b_name;
		}
		public void setB_name(String b_name) {
			this.b_name = b_name;
		}
		
		
}
