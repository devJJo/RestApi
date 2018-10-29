package com.devjjo.cafeteria.model;

public class User {

	//변수명은 디비의 컬럼명과 같아야한다. 대소문자 상관없음
	private String user_Id;
	private String user_Nm;
	private String user_Mail;
	private String user_Tel;
	private String Remark;
	public String getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Nm() {
		return user_Nm;
	}
	public void setUser_Nm(String user_Nm) {
		this.user_Nm = user_Nm;
	}
	public String getUser_Mail() {
		return user_Mail;
	}
	public void setUser_Mail(String user_Mail) {
		this.user_Mail = user_Mail;
	}
	public String getUser_Tel() {
		return user_Tel;
	}
	public void setUser_Tel(String user_Tel) {
		this.user_Tel = user_Tel;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String Remark) {
		this.Remark = Remark;
	}
	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", user_Nm=" + user_Nm + ", user_Mail=" + user_Mail + ", user_Tel="
				+ user_Tel + ", Remark=" + Remark + "]";
	}
	
	
	
}
