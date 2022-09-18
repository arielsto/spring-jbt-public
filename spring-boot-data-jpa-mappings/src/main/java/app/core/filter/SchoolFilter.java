package app.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.http.HttpStatus;

import com.google.common.net.HttpHeaders;

import app.core.auth.JwtUtilImpl;

public class SchoolFilter implements Filter {
	
	private JwtUtilImpl jwt;
	
	public SchoolFilter(JwtUtilImpl jwt){
		this.jwt = jwt;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("SchoolFilter called");
		
		HttpServletRequest req = (HttpServletRequest)request;
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		System.out.println("token: "+token);
		
		if (token == null) {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendError(HttpStatus.UNAUTHORIZED.value(), "No token");
			return;
		}
		
		if (token.startsWith("Bearer ")) {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendError(HttpStatus.UNAUTHORIZED.value(), "Wrong Schema");
			return;
		}
		
		token = token.replace("Bearer ", "");
		
		try {
			user user.jwt.extractUser(token);
			user.getPassword
		}

		chain.doFilter(request, response);

	}

}
