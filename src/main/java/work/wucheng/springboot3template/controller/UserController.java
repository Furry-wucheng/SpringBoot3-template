package work.wucheng.springboot3template.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import work.wucheng.springboot3template.common.Result;
import work.wucheng.springboot3template.service.UserService;

@RestController
@Tag(name = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "用户登录")
    @GetMapping("/login")
    public Result<String> login() {
        return userService.login();
    }
}
