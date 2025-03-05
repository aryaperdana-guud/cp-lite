package com.gli.clic.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final Logger logger = Logger.getLogger(JwtAuthenticationFilter.class.getName());

    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.replace("Bearer ", "");
            if (jwtTokenProvider.validateToken(token)) {
                String email = jwtTokenProvider.extractEmail(token);
                logger.info("Authenticated user: " + email);

                SecurityContextHolder.getContext().setAuthentication(
                        new org.springframework.security.authentication.UsernamePasswordAuthenticationToken(
                                new User(email, "", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))),
                                null,
                                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
                        )
                );
            } else {
                logger.warning("Invalid JWT Token detected");
            }
        } else {
            logger.warning("Missing or malformed Authorization header");
        }

        filterChain.doFilter(request, response);
    }
}
