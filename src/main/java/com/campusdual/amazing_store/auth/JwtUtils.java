package com.campusdual.amazing_store.auth;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Utility class for generating and validating JWT tokens.
 */
@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;


    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    /**
     * Generates a JWT token for a given username.
     *
     * @param username the username for which to generate a token
     * @return a JWT token as a string
     */
    public String generateToken(String username) {
//        System.out.println("jwtSecret y jwtExpirationMs" + jwtSecret + jwtExpirationMs);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
    /**
     * Retrieves the username from a given JWT token.
     *
     * @param token the JWT token
     * @return the username extracted from the token
     */
    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    /**
     * Validates a given JWT token.
     *
     * @param token the JWT token to validate
     * @return true if valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
