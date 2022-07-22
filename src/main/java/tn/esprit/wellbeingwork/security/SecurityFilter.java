package tn.esprit.wellbeingwork.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecurityFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public SecurityFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	

	public SecurityFilter() {
		this.authenticationManager = null;
	}


	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email, password);
		return authenticationManager.authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		super.successfulAuthentication(request, response, chain, authResult);
	}
}
