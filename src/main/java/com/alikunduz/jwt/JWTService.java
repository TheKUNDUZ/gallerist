package com.alikunduz.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTService {


    @Value("${jwt.secret}")
    public String secretKey ;

    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public <T> T exportToken(String token, Function<Claims , T> claimsTFunction) {
        Claims claims = getClaims(token);
        return claimsTFunction.apply(claims);
    }

    public Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token).getBody();

        return claims;
    }


    public String getUsernameByToken(String token) {
       return exportToken(token, Claims::getSubject);
    }


    public boolean isTokenValid(String token) {

        Date expireDate = exportToken(token, Claims::getExpiration);
        return new Date().before(expireDate);           // şuanın tarihi verilen tarihten küçükse true dönücek
    }                                                   // token geçerli yani

    public Key getKey() {

        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }


}













