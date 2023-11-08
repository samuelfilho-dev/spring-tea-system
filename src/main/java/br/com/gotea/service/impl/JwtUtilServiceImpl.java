package br.com.gotea.service.impl;

import br.com.gotea.domain.model.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;

@Service
public class JwtUtilServiceImpl {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private SecretKey getKeyBySecret() {
        return Keys.hmacShaKeyFor(this.secret.getBytes());
    }

    public String generateToken(String username) {
        var key = getKeyBySecret();

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + this.expiration))
                .signWith(key)
                .compact();
    }

    private Claims getClaims(String token) {
        var key = getKeyBySecret();
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String getUsername(String token) {
        var claims = getClaims(token);
        return claims.getSubject();
    }

    public boolean isValidToken(String token) {

        var claims = getClaims(token);

        if (Objects.nonNull(claims)) {

            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            return Objects.nonNull(username) && Objects.nonNull(expirationDate) && now.before(expirationDate);

        }

        return false;
    }
}
