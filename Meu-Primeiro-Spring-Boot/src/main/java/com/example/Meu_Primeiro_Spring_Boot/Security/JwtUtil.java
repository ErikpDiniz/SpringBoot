package com.example.Meu_Primeiro_Spring_Boot.Security;

import java.util.Date;

import javax.print.DocFlavor.STRING;

import java.security.Key;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {

    private static final Key key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME =86400000;

    public static String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setExpiration(new Date(System.currentTimeMillis() +EXPIRATION_TIME ))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public static String extractUsername(String token){
        return Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(token).getBody().getSubject();
    }

    public static boolean validadeToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
