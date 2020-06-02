package com.chobook.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chobook.bean.PhoneBean;

public interface PhoneMapper {

	@Insert("insert into phone_table(phone_idx, phone_name, phone_number, phone_month, phone_day, phone_memo, user_idx) " + 
			"values(phone_seq.nextval, #{phone_name}, #{phone_number}, #{phone_month}, #{phone_day}, #{phone_memo}, #{user_idx})")
	void addPhoneNumber(PhoneBean phoneBean);
	
	@Select("select * " + 
			"from phone_table " + 
			"where user_idx=#{user_idx}")
	List<PhoneBean> getList(String user_idx);
	
	@Select("select * " + 
			"from phone_table " +
			"where phone_idx=#{phone_idx}")
	PhoneBean getPhone(int phone_idx);
	
	@Delete("delete from phone_table " + 
			"where phone_idx=#{phone_idx}")
	void deletePhone(int phone_idx);
	
	@Update("update phone_table " + 
			"set phone_name=#{phone_name}, phone_number=#{phone_number}, " + 
			"phone_memo=#{phone_memo}, phone_month=#{phone_month}, phone_day=#{phone_day} " +
			"where phone_idx=#{phone_idx}")
	void updatePhone(PhoneBean updatePhoneBean);
}
