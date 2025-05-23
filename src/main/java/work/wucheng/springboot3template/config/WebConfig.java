package work.wucheng.springboot3template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import work.wucheng.springboot3template.interceptor.TokenInterceptor;

/**
 * Web配置类
 * 主要用于配置拦截器和跨域请求
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/register")
                //排除swagger相关请求
                .excludePathPatterns(
                        "/doc.html",
                        "/v3/api-docs/**",
                        "/swagger-resources/**",
                        "/webjars/**",
                        "/swagger-ui/**",
                        "/v2/api-docs/**",
                        "/favicon.ico",
                        "/.well-known/**"
                );
    }

    //添加跨域处理
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600);
    }

}
