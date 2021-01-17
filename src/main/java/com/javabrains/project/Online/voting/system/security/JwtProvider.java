package com.javabrains.project.Online.voting.system.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.HashMap;

@Slf4j
@Service
public class JwtProvider {

    private static Key key;

    @PostConstruct
    public void init() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(String email) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", email);
        String login_token = Jwts.builder()
                .setSubject("login token")
                .addClaims(map)
                .signWith(key)
                .compact();
        log.info("login_token " + login_token);
        return login_token;
    }

    public Boolean validateToken(String token) {
        Jws<Claims> claimsJws = Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token);
        System.out.println(claimsJws.getBody());
        return true;
    }


}
