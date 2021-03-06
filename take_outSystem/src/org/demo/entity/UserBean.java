package org.demo.entity;

//创建用户实体
public class UserBean {
	//用户属性
	private int uid;
	private String uname;
	private String upwd;
	private String usex;
	private String uaddr;
	private String uemail;
	private String utel;
	private float umonetary;
	private RoleBean rtype;
	 
	//无参构造方法
	public UserBean() {
		super();
	}
	//有参构造方法

	public UserBean(int uid, String uname, String upwd, String usex, String uaddr, String uemail, String utel,
			float umonetary, RoleBean rtype) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
		this.uaddr = uaddr;
		this.uemail = uemail;
		this.utel = utel;
		this.umonetary = umonetary;
		this.rtype = rtype;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUaddr() {
		return uaddr;
	}
	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public RoleBean getRtype() {
		return rtype;
	}
	public void setRtype(RoleBean rtype) {
		this.rtype = rtype;
	}
	
	public float getUmonetary() {
		return umonetary;
	}
	public void setUmonetary(float umonetary) {
		this.umonetary = umonetary;
	}
	@Override
	public String toString() {
		return "UserBean [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", usex=" + usex + ", uaddr=" + uaddr
				+ ", uemail=" + uemail + ", utel=" + utel + ", umonetary=" + umonetary + ", rtype=" + rtype + "]";
	}
	
}
