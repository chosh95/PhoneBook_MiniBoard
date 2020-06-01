package com.chobook.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class PhoneBean {
	
	private int phone_idx;
	
	@Size(min=2,max=6)
	@Pattern(regexp="[가-힣]*")
	private String phone_name;
	
	@Size(min=11, max = 14)
	@Pattern(regexp="^\\d{2,3}-\\d{3,4}-\\d{4}$")
	private String phone_number;
	
	@Min(1)
	@Max(12)
	private int phone_month;
	
	@Min(1)
	@Max(31)
	private int phone_day;
		
	private String phone_memo;
	private String user_idx;
	
	public int getPhone_idx() {
		return phone_idx;
	}
	public void setPhone_idx(int phone_idx) {
		this.phone_idx = phone_idx;
	}
	public String getPhone_name() {
		return phone_name;
	}
	public void setPhone_name(String phone_name) {
		this.phone_name = phone_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getPhone_month() {
		return phone_month;
	}
	public void setPhone_month(int phone_month) {
		this.phone_month = phone_month;
	}
	public int getPhone_day() {
		return phone_day;
	}
	public void setPhone_day(int phone_day) {
		this.phone_day = phone_day;
	}
	public String getPhone_memo() {
		return phone_memo;
	}
	public void setPhone_memo(String phone_memo) {
		this.phone_memo = phone_memo;
	}
	public String getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(String user_idx) {
		this.user_idx = user_idx;
	}
	
}
