package com.chobook.service;

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
}
