package com.orderapi.spring;

import com.orderapi.spring.config.ConfigProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sun.security.internal.spec.TlsPrfParameterSpec;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

public class JWTUtil {
    private static String apiKey="svdgtef2356_fvwetv62";

    private static String getClaim(String jwt) {
        String  userId="";
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(apiKey))
                .parseClaimsJws(jwt).getBody();

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        Date exp = claims.getExpiration();

        if(exp.before(now)){
            userId = claims.getId();
        }
        return userId;
    }

    public static String createJWT(String id) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(ConfigProperties.subject)
                .setIssuer(ConfigProperties.issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (Integer.parseInt(ConfigProperties.sessionExpiry) >= 0) {
            long expMillis = nowMillis + Integer.parseInt(ConfigProperties.sessionExpiry);
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
}
