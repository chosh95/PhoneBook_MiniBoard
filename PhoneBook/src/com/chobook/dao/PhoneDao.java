package com.chobook.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chobook.bean.PhoneBean;
import com.chobook.mapper.PhoneMapper;

@Repository
public class PhoneDao {
	
	@Autowired
	PhoneMapper phoneMapper;
	
	public void addPhoneNumber(PhoneBean phoneBean) {
		phoneMapper.addPhoneNumber(phoneBean);
	}
	
	public List<PhoneBean> getList(String user_idx){
		return phoneMapper.getList(user_idx);
	}
	
	public PhoneBean getPhone(int phone_idx) {
		return phoneMapper.getPhone(phone_idx);
	}
	
	public void deletePhone(int phone_idx) {
		phoneMapper.deletePhone(phone_idx);
	}
}
