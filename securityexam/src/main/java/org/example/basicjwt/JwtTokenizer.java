package org.example.basicjwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
@Component
public class JwtTokenizer {

    private final byte[] accessSecret;
    private final byte[] refreshSecret;
//
//    public final static Long ACCESS_TOKEN_EXPIRE_COUNT = 30 * 60 * 1000L; // 30분
//    public final static Long REFRESH_TOKEN_EXPIRE_COUNT = 7 * 24 * 60 * 60 * 1000L; // 7일
    private final long accessExpirationMs;
    private final long refreshExpirationMs;

    public JwtTokenizer(@Value("${jwt.secretKey}") String accessSecret,
                        @Value("${jwt.refreshKey}") String refreshSecret,
                        @Value("${jwt.access-expiration-ms}") long accessExpirationMs,
                        @Value("${jwt.refresh-expiration-ms}")long refreshExpirationMs) {
        this.accessSecret = accessSecret.getBytes(StandardCharsets.UTF_8);
        this.refreshSecret = refreshSecret.getBytes(StandardCharsets.UTF_8);

        this.accessExpirationMs = accessExpirationMs;
        this.refreshExpirationMs = refreshExpirationMs;
    }

    /**
     * Access Token 생성
     */
    public String createAccessToken(Long id, String email, String name,
                                    String username, List<String> roles) {
        return createToken(id, email, name, username, roles,
                accessExpirationMs, accessSecret);
    }

    private String createToken(Long id, String email, String name, String username, List<String> roles, Long expire, byte[] secretKey){
        Date now = new Date();
        Date expiration = new Date(now.getTime()+ expire);

        return Jwts.builder()
                .subject(email) //로그인아이디.
                .claim("username",username)
                .claim("name",name)
                .claim("userId", id)
                .claim("roles",roles)
                .issuedAt(now)
                .expiration(expiration)
                .signWith(getSigingKey(secretKey))
                .compact();
    }

    private SecretKey getSigingKey(byte[] secretKey){
//        new SecretKeySpec(secretKey,"HmacSHA256");
        return Keys.hmacShaKeyFor(secretKey);

    }


}
