package com.Insta.instaClone.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtTokenValidationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String jwt = request.getHeader(SecurityContext.HEADER);

        if (jwt != null) {

            try {
                SecretKey key = Keys.hmacShaKeyFor(SecurityContext.JWT_KEY.getBytes());

                Jws<Claims> claimsJws = Jwts.parser()
                        .verifyWith(key)
                        .build()
                        .parseSignedClaims(jwt);

                Claims claims = claimsJws.getPayload();

                String username = String.valueOf(claims.get("username"));
                String authoritiesStr = String.valueOf(claims.get("authorities"));

                List<GrantedAuthority> authorities = new ArrayList<>();
                if (authoritiesStr != null && !authoritiesStr.isBlank() && !authoritiesStr.equals("null")) {
                    for (String authority : authoritiesStr.split(",")) {
                        authorities.add(new SimpleGrantedAuthority(authority.trim()));
                    }
                }

                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(username, null, authorities);

                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {
                throw new BadCredentialsException("Invalid token received");
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest req) throws ServletException {
        return req.getServletPath().equals("/signin");
    }
}