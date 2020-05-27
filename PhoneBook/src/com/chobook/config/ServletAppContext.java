package com.chobook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스
@Configuration
// Controller 어노테이션이 셋팅되어 있는 클래스를 Controller로 등록한다.
@EnableWebMvc
// 스캔할 패키지를 지정한다.
@ComponentScan("com.chobook.controller")
public class ServletAppContext implements WebMvcConfigurer{
	// Controller의 메서드가 반환하는 jsp의 이름 앞뒤에 경로와 확장자를 붙혀주도록 설정한다.
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	// 정적 파일의 경로를 매핑한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public GoogleConnectionFactory googleConnectionFactory() {
		return new GoogleConnectionFactory("1043729165158-nca747cc5g30oq19eosvasn19kuubgoa.apps.googleusercontent.com", "phoG3u-JA3vsGyz_Iv8YHklf");
	}
	
	@Bean
	public ConnectionFactoryLocator connectionFactoryLocator() {
		ConnectionFactoryRegistry regist = new ConnectionFactoryRegistry();
		regist.addConnectionFactory(googleConnectionFactory());
		return regist;
	}
	
	@Bean
	public OAuth2Parameters googleOAuth2Parameters() {
		OAuth2Parameters oAuth2Parameters = new OAuth2Parameters();
		String scope =  "https://www.googleapis.com/auth/plus.login";
		String redirectUri = "http://localhost:8080/PhoneBook/oauth2callback";
		oAuth2Parameters.setScope(scope);
		oAuth2Parameters.setRedirectUri(redirectUri);
		return oAuth2Parameters;
	}
}