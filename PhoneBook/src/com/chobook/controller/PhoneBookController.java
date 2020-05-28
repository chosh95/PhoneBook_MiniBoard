package com.chobook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhoneBookController {

	@GetMapping("/phoneBook/main")
	public String phoneBook() {
		return "phoneBook/main";
	}
	
	@GetMapping("/phoneBook/search")
	public String search() {
		return "phoneBook/search";
	}
	
	@GetMapping("/phoneBook/insert")
	public String insert() {
		return "phoneBook/insert";
	}
}
