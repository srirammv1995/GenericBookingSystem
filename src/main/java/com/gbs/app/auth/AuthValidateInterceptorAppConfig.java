package com.gbs.app.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class AuthValidateInterceptorAppConfig implements WebMvcConfigurer{

	@Bean
	AuthValidateInterceptor authValidateInterceptor()
	{
		return new AuthValidateInterceptor();
	}
	
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      List<String> patterns = new ArrayList<String>();
	      patterns.add("auth/**");
	      patterns.add("/user/create");
		registry.addInterceptor(authValidateInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
	   }
}
