package tn.esprit.wellbeingwork.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpClientErrorException.Forbidden;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthorizationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/login")) {
			filterChain.doFilter(request, response);
		} else {
			String authorizationHeader = request.getHeader("Authorization");
		
				if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
					try {
					String token = authorizationHeader.substring("Bearer ".length());
					Algorithm algo = Algorithm.HMAC256("secret".getBytes());
					JWTVerifier verifier = JWT.require(algo).build();
					DecodedJWT decodedJWT = verifier.verify(token);
					String email = decodedJWT.getSubject();
					List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
					Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
					roles.forEach(role -> {
						authorities.add(new SimpleGrantedAuthority(role));
					});
					UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(email,
							null);
					SecurityContextHolder.getContext().setAuthentication(authToken);
					filterChain.doFilter(request, response);}
					catch (Exception exception) {			
						logger.error(exception.getMessage(), exception);
						response.setHeader("error", exception.getMessage());
						response.setStatus(401);
						Map<String, String> error = new HashMap<>();
						error.put("error_message", exception.getMessage());
						response.setContentType("application/json");
						new ObjectMapper().writeValue(response.getOutputStream(), error);					}
				}else {
					response.setHeader("error", "Unauthorized");
					response.setStatus(401);
					new ObjectMapper().writeValue(response.getOutputStream(), "Unauthorized");					}
				}
					

				 
			} 
		}
	
