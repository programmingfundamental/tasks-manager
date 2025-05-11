package bg.tu_varna.sit.task_manager.component;

import bg.tu_varna.sit.task_manager.exception.TaskApiException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Добавено в лабораторно упражнение 11
 */
@Component
public class JwtTokenProvider {
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private int expirationTime;
    private SecretKey key;
    private JwtParser jwtParser;
    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        this.jwtParser = Jwts.parser().verifyWith(key).build();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return jwtParser
                .parseSignedClaims(token)
                .getPayload();
    }

    public String generateToken(Authentication authentication) {
        return generateToken(new HashMap<>(), authentication);
    }

    private String generateToken(Map<String, Object> extraClaims, Authentication authentication) {
        return buildToken(extraClaims, authentication, expirationTime);
    }

    private String buildToken(Map<String, Object> extraClaims, Authentication authentication, long expiration) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(authentication.getName())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key)
                .compact();

    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + expirationTime))
                .signWith(key)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public boolean validateToken(String token) throws TaskApiException {
        try {
            this.jwtParser
                    .parse(token);
            return true;
        }
        catch (MalformedJwtException ex) {
            throw new TaskApiException("Invalid JWT token");
        }
        catch (ExpiredJwtException ex) {
            throw new TaskApiException("Expired JWT token");
        }
        catch (UnsupportedJwtException ex) {
            throw new TaskApiException("Unsupported JWT token");
        }
        catch (IllegalArgumentException ex) {
            throw new TaskApiException("JWT string claims is empty");
        }
    }
}
