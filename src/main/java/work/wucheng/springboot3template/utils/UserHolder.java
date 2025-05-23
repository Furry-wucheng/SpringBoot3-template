package work.wucheng.springboot3template.utils;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import work.wucheng.springboot3template.dto.UserDTO;

/**
 * 用户信息持有工具类
 */
public class UserHolder {
    private static ThreadLocal<UserDTO> threadLocal = new ThreadLocal<>();

    public static void saveUser(UserDTO user) {
        threadLocal.set(user);
    }

    public static UserDTO getUser() {
        return threadLocal.get();
    }
}

/**
 * 用户信息持有工具类（依赖Spring生命周期实现）
 */
/*
@Component
@Scope(
        scopeName = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS
)
public class UserHolder {
    private UserDTO currentUser;

    public UserDTO getUser() {
        return currentUser;
    }

    public void SetUser(UserDTO user) {
        this.currentUser = user;
    }
}*/
