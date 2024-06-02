package com.SE102.ScholarshipApplicationSystem.config;

import com.SE102.ScholarshipApplicationSystem.service.AdminDetailService;
import com.SE102.ScholarshipApplicationSystem.service.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilterAdmin extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private AdminDetailService adminDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwtToken;
        final String email;

        if(authHeader == null || authHeader.isBlank()){
            filterChain.doFilter(request, response);
            return;
        }

        jwtToken = authHeader.substring(7);
        email = jwtUtils.extractUsername(jwtToken);
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = adminDetailService.loadUserByUsername(email);
            if(jwtUtils.isTokenValid(jwtToken, userDetails)){
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                securityContext.setAuthentication(token);
                SecurityContextHolder.setContext(securityContext);
            }
        }

        filterChain.doFilter(request, response);

    }
}
