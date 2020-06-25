package server.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;

/**
 * @author quyuxi
 * @since 2020/5/20
 */
public class JwtUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);
    /**
     * 过期时间为一天
     */
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;

    /**
     * token私钥
     */
    private static final String TOKEN_SECRET = "cjubg-12bxfn-157sdf-8gsdad-sads5-gas554-cgas4ga";

    /**
     * 生成签名
     *
     * @param id
     * @param role
     * @return
     */
    public static String sign(String id, int role) {
        //过期时间
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        //私钥及加密算法
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        //附带username和userID生成签名
        return JWT.create().withHeader(header).withClaim("id", id)
                .withClaim("role", role).withExpiresAt(date).sign(algorithm);
    }

    /**
     * 验证
     *
     * @param token
     * @return
     */
    public static Integer verity(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("role").asInt();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            LOGGER.error("鉴权失败,token无效");
            return null;
        }

    }

    public static String getId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("id").asString();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            LOGGER.error("鉴权失败,token无效");
            return null;
        }
    }
}
