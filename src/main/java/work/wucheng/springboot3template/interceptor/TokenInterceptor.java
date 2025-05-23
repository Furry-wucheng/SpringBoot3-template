package work.wucheng.springboot3template.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import work.wucheng.springboot3template.dto.UserDTO;
import work.wucheng.springboot3template.utils.JwtUtils;
import work.wucheng.springboot3template.utils.UserHolder;

/**
 * Token拦截器
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求路径: {}", request.getRequestURI());
        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            throw new RuntimeException("token无效");
        }
        // 解析token
        token = token.replace("Bearer ", "");

        UserDTO userDTO = null;
        try {
            userDTO = JwtUtils.parseToken(token);
            UserHolder.saveUser(userDTO);
        } catch (ExpiredJwtException e) {
            throw new RuntimeException("token已过期");
        } catch (JwtException e) {
            throw new RuntimeException("token无效");
        }

        if (userDTO == null){
            return false;
        }

        return true;

    }
}
