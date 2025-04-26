package com.leo.crud.vendas.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.leo.crud.vendas.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class GeneratedHash {

    @Value("${SALT}")
    private String salt;

    @Value("${SECRET_KEY}")
    private String key;

    public String generatedHash(String... words){
        try{

            StringBuilder keys = new StringBuilder();
            keys.append(words);
            keys.append(this.salt);

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            byte[] hash = messageDigest.digest(keys.toString().getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("Não possivel gerar hash");
        }
    }

    public String generationToken(User user){
        try{

            Algorithm algorithm = Algorithm.HMAC256(key);

            String token = JWT.create()
                    .withIssuer("crud-vendas")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpiresDate())
                    .sign(algorithm);

            return token;

        }catch (JWTCreationException e){
            throw new RuntimeException("Não foi possivel gerar token", e);
        }
    }

    public String verifyToken(String token){
        try{

            Algorithm algorithm = Algorithm.HMAC256(key);

            return JWT.require(algorithm)
                    .withIssuer("crud-vendas")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException e){
            throw new RuntimeException("Não foi possivel verificar token", e);
        }
    }

    private Instant generateExpiresDate(){
        return LocalDateTime.now().plusMinutes(15L).toInstant(ZoneOffset.of("-04:00"));
    }

}
