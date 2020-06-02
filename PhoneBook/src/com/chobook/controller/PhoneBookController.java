package com.chobook.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String search(Model model) {
		List<PhoneBean> list = phoneService.getList(loginUserBean.getUserId());
		model.addAttribute("list",list);
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
	
	@GetMapping("/phoneBook/read")
	public String read(@RequestParam int phone_idx, Model model) {
		PhoneBean readPhoneBean = new PhoneBean();
		readPhoneBean = phoneService.getPhone(phone_idx);
		model.addAttribute("readPhoneBean", readPhoneBean);
		return "phoneBook/read";
	}
	
	@GetMapping("/phoneBook/delete")
	public String delete(@RequestParam int phone_idx) {
		phoneService.deletePhone(phone_idx);
		return "phoneBook/delete";
	}
	
	@GetMapping("/phoneBook/update")
	public String update(@RequestParam int phone_idx, Model model) {
		
		PhoneBean updatePhoneBean= phoneService.getPhone(phone_idx);
		model.addAttribute("updatePhoneBean", updatePhoneBean);
		return "phoneBook/update";
	}
	
	@PostMapping("/phoneBook/update_pro")
	public String update_pro(@Valid @ModelAttribute("updatePhoneBean") PhoneBean updatePhoneBean,
							 BindingResult result) {
		if(result.hasErrors()) {
			return "phoneBook/update";
		}
		System.out.println("update pro 1 : " + updatePhoneBean.getPhone_name() + updatePhoneBean.getPhone_idx() + updatePhoneBean.getUser_idx());
		phoneService.updatePhone(updatePhoneBean);
		System.out.println("update pro 2 : " + updatePhoneBean.getPhone_name() + updatePhoneBean.getPhone_idx() + updatePhoneBean.getUser_idx());
		return "phoneBook/update_success";
	}

}
