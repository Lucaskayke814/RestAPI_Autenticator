package com.example.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    private static final SecretKey SECRET_KEY = generateSecretKey();
    private static final String SECRET_STRING = getSecretString();
    private static final long EXPIRATION_TIME = 864_000_000;

    private static SecretKey generateSecretKey(){
        SecretKey key = Jwts.SIG.HS512.key().build();
        return key;
    }

    public static String getSecretString(){
        String secretString = Encoders.BASE64.encode(SECRET_KEY.getEncoded());
        return secretString;
    }

    public static String generatedToken(String username){
        String token = Jwts.builder().subject(username).expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(SECRET_KEY).compact();
        return token;
    }

    public static String extractUsername(String token){
        SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));
        return Jwts.parser().verifyWith(secret).build().parseSignedClaims(token).getPayload().getSubject();
    }

}
