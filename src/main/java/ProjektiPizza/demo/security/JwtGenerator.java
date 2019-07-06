package ProjektiPizza.demo.security;

import ProjektiPizza.demo.config.Constants;
import ProjektiPizza.demo.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {
    Constants constants = new Constants();
    Date date = new Date();
    Date validy = new Date(date.getTime() + constants.getValidityInMs());

    public String generate(User user) {
        Claims claims = Jwts.claims()
                .setSubject(user.getUsername());
        claims.setSubject(user.getPassword());
        claims.setSubject(user.getFullName());
        return Jwts.builder()
                .setClaims(claims).setExpiration(validy)
                .signWith(SignatureAlgorithm.HS512, Constants.getSecret())
                .compact();
    }
}
