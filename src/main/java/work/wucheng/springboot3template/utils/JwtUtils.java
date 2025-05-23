package work.wucheng.springboot3template.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import work.wucheng.springboot3template.dto.UserDTO;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * JWT工具类
 */
public class JwtUtils {

    private final static SecureDigestAlgorithm<SecretKey, SecretKey> ALGORITHM = Jwts.SIG.HS256;

    private static final String SECRET_KEY = "wucheng-springboot3-template";
    public static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final static String JWT_ISS = "WuCheng";

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static String createToken(UserDTO user) {
        String json = null;
        try {
            json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("序列化对象失败："+e);
        }
        return Jwts.builder()
                .claim("user", json)
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                .signWith(KEY, ALGORITHM)
                .issuer(JWT_ISS)
                .compact();
    }

    public static UserDTO parseToken(String token) {
        String json = Jwts.parser()
                .verifyWith(KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("user", String.class);
        UserDTO userDTO = null;
        try {
            userDTO = mapper.readValue(json, UserDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("反序列化对象失败"+e);
        }
        return userDTO;
    }
}
