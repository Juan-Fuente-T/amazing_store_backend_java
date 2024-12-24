package com.campusdual.amazing_store.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;


    @Override
    protected void doFilterInternal(@NonNull jakarta.servlet.http.HttpServletRequest request,
                                    @NonNull jakarta.servlet.http.HttpServletResponse response,
                                    @NonNull jakarta.servlet.FilterChain filterChain)
            throws jakarta.servlet.ServletException, IOException {

        String jwt = parseJwt(request);
//        logger.info("Received JWT: " + jwt);
        if (jwt != null && jwtUtils.validateToken(jwt)) {
            String username = jwtUtils.getUsernameFromToken(jwt);
//            logger.info("Authenticated user: " + username);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(username, null, null);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            logger.warn("Invalid JWT token");
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwt(jakarta.servlet.http.HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
    }
}
