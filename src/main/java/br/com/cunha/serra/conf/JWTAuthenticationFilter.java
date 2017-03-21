package br.com.cunha.serra.conf;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.security.core.Authentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class JWTAuthenticationFilter extends GenericFilterBean  {

	
	
	 @Override
	  public void doFilter(ServletRequest request,
	             ServletResponse response,
	             FilterChain filterChain)
	      throws IOException, ServletException {
		 System.out.println("JWTAuthenticationFilter - doFilter ");
	    Authentication authentication = TokenAuthenticationService
	        .getAuthentication((HttpServletRequest)request);
	    
	    ///System.out.println("JWTAuthenticationFilter - doFilter - getPrincipal : "+authentication.getPrincipal()+" Credencials : "+authentication.getCredentials()+" roles : "+authentication.getAuthorities().size());
	  
	    SecurityContextHolder.getContext()
	        .setAuthentication(authentication);
	    filterChain.doFilter(request,response);
	  }
	}
