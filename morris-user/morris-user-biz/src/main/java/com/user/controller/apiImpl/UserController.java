package com.user.controller.apiImpl;

import com.user.api.common.api.Result;
import com.user.api.facade.UserFacade;
import com.user.api.response.UserResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements UserFacade {
    @Override
    public Result<UserResponse> getUserById(@PathVariable(value = "id") Integer id) {
        String formatted = "\"%d\"".formatted(128);
        System.out.println(formatted);
        return Result.success();
    }
}
