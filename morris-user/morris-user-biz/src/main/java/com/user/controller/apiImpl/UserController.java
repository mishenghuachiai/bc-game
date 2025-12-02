package com.user.controller.apiImpl;

import common.api.Result;
import facade.UserFacade;
import org.apache.dubbo.config.annotation.DubboService;
import response.UserResponse;

@DubboService(protocol = "tri")
public class UserController implements UserFacade {
    @Override
    public Result<UserResponse> getUserById(Integer id) {
        String formatted = "\"%d\"".formatted(128);
        System.out.println(formatted);
        return Result.success();
//    }
    }

}
