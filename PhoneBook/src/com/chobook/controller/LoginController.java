package com.chobook.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chobook.bean.UserBean;
import com.chobook.social.NaverLoginBO;
import com.github.scribejava.core.model.OAuth2AccessToken;

@Controller
public class LoginController {
	
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/user/naverLogin")
	public String naverLogin(Model model, HttpSession session) {
        
        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addAttribute("url", naverAuthUrl);

        /* 생성한 인증 URL을 View로 전달 */
		return "/user/naverLogin";
	}
	
	@GetMapping("/user/naverCallBack")
	public String naverCallBack(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
        System.out.println("여기는 callback");
        OAuth2AccessToken oauthToken;
        oauthToken = naverLoginBO.getAccessToken(session, code, state);
        //로그인 사용자 정보를 읽어온다.
        apiResult = naverLoginBO.getUserProfile(oauthToken);
        System.out.println(naverLoginBO.getUserProfile(oauthToken).toString());
        model.addAttribute("result", apiResult);
        System.out.println("result "+apiResult);
        
        /* 네이버 로그인 성공 페이지 View 호출 */
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonobj = (JSONObject)parser.parse(apiResult);
			JSONObject parse_response = (JSONObject)jsonobj.get("response");
			String id = (String)parse_response.get("id");
			String name = (String)parse_response.get("name");
			String email = (String)parse_response.get("email");
			String birthday = (String)parse_response.get("birthday");
			
			System.out.println(name + " " + id + " " + email);
			
			loginUserBean.setLogin(true);
			loginUserBean.setUserId(id);
			loginUserBean.setUserName(name);
			loginUserBean.setUserBirthday(birthday);
			System.out.println("callback " + loginUserBean.isLogin());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "/user/naverCallBack";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		loginUserBean.setLogin(false);
		System.out.println("logout " + loginUserBean.isLogin());
		return "/user/logout";
	}

}
