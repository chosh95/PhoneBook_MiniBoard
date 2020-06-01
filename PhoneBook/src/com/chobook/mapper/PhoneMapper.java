package com.chobook.mapper;

import org.apache.ibatis.annotations.Insert;

import com.chobook.bean.PhoneBean;

public interface PhoneMapper {

	@Insert("insert into phone_table(phone_idx, phone_name, phone_number, phone_month, phone_day, phone_memo, user_idx) " + 
			"values(phone_seq.nextval, #{phone_name}, #{phone_number}, #{phone_month}, #{phone_day}, #{phone_memo}, #{user_idx})")
	void addPhoneNumber(PhoneBean phoneBean);
	
}
