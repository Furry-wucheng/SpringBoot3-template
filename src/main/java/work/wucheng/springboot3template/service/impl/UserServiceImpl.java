package work.wucheng.springboot3template.service.impl;

import org.springframework.stereotype.Service;
import work.wucheng.springboot3template.common.Result;
import work.wucheng.springboot3template.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Result<String> login() {
        return Result.success("Login successful");
    }
}
