package com.user.controller.apiImpl;

import com.user.api.common.api.Result;
import com.user.api.facade.UserFacade;
import com.user.api.response.UserResponse;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements UserFacade {
    @Override
    public Result<UserResponse> getUserById(Integer id) {
        String formatted = "\"%d\"".formatted(1000+id);
        System.out.println(formatted);
        return Result.success();
    }
}
