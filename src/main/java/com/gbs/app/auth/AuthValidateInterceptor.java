package com.gbs.app.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import com.gbs.app.constants.Constants;
import com.gbs.app.jwt.JwtUtil;

import io.jsonwebtoken.Claims;

public class AuthValidateInterceptor implements HandlerInterceptor {

	@SuppressWarnings("rawtypes")
	@Autowired
	RedisTemplate redisTemplate;

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String AuthToken = request.getHeader("x-auth-token");
		if (AuthToken != null && !AuthToken.isEmpty()) {
			Claims claims = JwtUtil.decodeJWT(AuthToken);
			String token = (String) redisTemplate.opsForHash().get(claims.getId(), Constants.AUTH_KEY);
			if (token == null || token.isEmpty()) {
				throw new Exception("JWT token is invalid or expired");
			}
		} else {
			throw new Exception("please Login and try again");
		}
		return true;
	}
}
