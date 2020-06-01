package com.chobook.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chobook.bean.PhoneBean;
import com.chobook.bean.UserBean;
import com.chobook.service.PhoneService;

@Controller
public class PhoneBookController {
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("/phoneBook/main")
	public String phoneBook() {
		return "phoneBook/main";
	}
	
	@GetMapping("/phoneBook/search")
	public String search() {
		return "phoneBook/search";
	}
	
	@GetMapping("/phoneBook/insert")
	public String insert(@ModelAttribute("phoneBean") PhoneBean phoneBean) {
		return "phoneBook/insert";
	}
	
	@PostMapping("/phoneBook/insert_pro")
	public String insert_pro(@Valid @ModelAttribute("phoneBean") PhoneBean phoneBean, BindingResult result) {
		if(result.hasErrors()) {
			return "phoneBook/insert";
		}
		phoneBean.setUser_idx(loginUserBean.getUserId());
		phoneService.addPhoneNumber(phoneBean);
		return "phoneBook/insert_success";
	}
}
