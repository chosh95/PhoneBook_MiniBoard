package com.chobook.dao;

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
}
