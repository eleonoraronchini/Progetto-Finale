package ProgettoFInale.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTTools {
    @Value("${spring.jwt.secret}") String secret;

    public String createToken(String email, Object o){
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis()+(15*60*1000)))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
    public String decodeToken (String token){
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secret.getBytes()))
                .build().parseClaimsJws(token).getBody().getSubject();
    }
}
