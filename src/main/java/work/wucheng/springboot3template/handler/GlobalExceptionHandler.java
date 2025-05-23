package work.wucheng.springboot3template.handler;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import work.wucheng.springboot3template.common.Result;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ExpiredJwtException.class})
    public ResponseEntity<Result<String>> handleTokenExpiredException(ExpiredJwtException ex) {
        Result<String> result = Result.error("token已过期");
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = { JwtException.class })
    public ResponseEntity<Result<String>> handleJwtException(JwtException ex) {
        Result<String> result = Result.error("token无效");
        return new ResponseEntity<>(result, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Result<String>> handleUnknownException(Exception ex) {
        Result<String> result = Result.error("An unexpected error occurred: " + ex.getMessage());
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
