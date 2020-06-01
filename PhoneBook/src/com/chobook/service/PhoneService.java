package com.chobook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chobook.bean.PhoneBean;
import com.chobook.dao.PhoneDao;

@Service
public class PhoneService {

	@Autowired
	private PhoneDao phoneDao;
	
	public void addPhoneNumber(PhoneBean phoneBean) {
		phoneDao.addPhoneNumber(phoneBean);
	}
	
	public List<PhoneBean> getList(String user_idx){
		return phoneDao.getList(user_idx);
	}
	
	public PhoneBean getPhone(int phone_idx) {
		return phoneDao.getPhone(phone_idx);
	}
	
	public void deletePhone(int phone_idx) {
		phoneDao.deletePhone(phone_idx);
	}
}
