package br.com.hennan.projeto.security.jwt;

import br.com.hennan.projeto.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value(value = "${projeto.jwtSecret}")
    private static String jwtSecret;

    @Value(value = "${projeto.jwtExpirationMs}")
    private static int jwtExpirationMs;

    public static String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
        return Jwts.builder().setSubject(userDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public static Key getSigninKey() {
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public String getUsernameToken(String token) {
        return Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException exception) {
            System.out.println("Token Invalido " + exception.getMessage());
        } catch (ExpiredJwtException exception) {
            System.out.println("Token Expirado " + exception.getMessage());
        } catch (UnsupportedJwtException exception) {
            System.out.println("Token não suportado " + exception.getMessage());
        } catch (IllegalArgumentException exception) {
            System.out.println("Token Argumento Inválido " + exception.getMessage());
        }
        return false;
    }
}
