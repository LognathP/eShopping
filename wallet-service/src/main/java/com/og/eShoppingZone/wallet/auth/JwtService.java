package com.og.eShoppingZone.wallet.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class JwtService {


    public JwtService() {

    }

    @Value("${jwt.secret}")
	private String secret;


    public Jws<Claims> verify(String token) throws IOException, URISyntaxException {

        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    }
}
