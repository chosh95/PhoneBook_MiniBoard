package com.chobook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;
	
	@Autowired
	private OAuth2Parameters oAuth2Parameters;
	
	@GetMapping("/login")
	public String login(Model model) {
		OAuth2Operations oauth = googleConnectionFactory.getOAuthOperations();
		String url = oauth.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
		System.out.println("구글:" + url);
		model.addAttribute("google_url", url);
		
		return "login";
	}
	
	@GetMapping("/oauth2callback")
	public String googleCallback() {
		return "googleSuccess";
	}
}
