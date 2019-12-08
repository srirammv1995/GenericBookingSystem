package com.gbs.app.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AuthValidateInterceptorAppConfig implements WebMvcConfigurer{

	@Autowired
	AuthValidateInterceptor authValidateInterceptor;
	
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      List<String> patterns = new ArrayList<String>();
	      patterns.add("/address/**");
	      patterns.add("/payment/**");
	      patterns.add("/session/**");
	      patterns.add("/subscription/**");
	      patterns.add("/transaction/**");
	      patterns.add("/user/viewById");
	      patterns.add("/user/viewByName");
	      patterns.add("/user/modify");
	      patterns.add("/user/delete");
	      patterns.add("/user/all");
		registry.addInterceptor(authValidateInterceptor).addPathPatterns(patterns);
	   }
}
