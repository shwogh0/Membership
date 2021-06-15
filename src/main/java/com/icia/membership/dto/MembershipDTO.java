package com.icia.membership.dto;

import org.springframework.web.multipart.MultipartFile;


public class MembershipDTO {
	private String mid;
	private String mpassword;
	private String mname;
	private String mphone;
	private String memail;
	private MultipartFile mfile;
	private String mfilename;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public MultipartFile getMfile() {
		return mfile;
	}
	public void setMfile(MultipartFile mfile) {
		this.mfile = mfile;
	}
	public String getMfilename() {
		return mfilename;
	}
	public void setMfilename(String mfilename) {
		this.mfilename = mfilename;
	}
	@Override
	public String toString() {
		return "MembershipDTO [mid=" + mid + ", mpassword=" + mpassword + ", mname=" + mname + ", mphone=" + mphone
				+ ", memail=" + memail + ", mfile=" + mfile + ", mfilename=" + mfilename + "]";
	}
	
	
}
