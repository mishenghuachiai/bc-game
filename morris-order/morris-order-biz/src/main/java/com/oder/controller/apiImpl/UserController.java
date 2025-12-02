package com.oder.controller.apiImpl;

import common.api.Result;
import facade.UserFacade;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import response.UserResponse;

@RestController
public class UserController implements UserFacade {
    @Override
    public Result<UserResponse> getUserById(@PathVariable(value = "id") Integer id) {
        String formatted = "\"%d\"".formatted(128);
        System.out.println(formatted);
        return Result.success();
    }
}
