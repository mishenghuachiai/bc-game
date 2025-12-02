package com.oder.controller.admin;


import common.api.Result;
import facade.UserFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.UserResponse;

@RestController
@RequestMapping("/api/v1/orders")
public class UserOrderController {

    @DubboReference(url = "tri://127.0.0.1:50051", timeout = 30000, group = "DUBBO", version = "1.0.0")
    private UserFacade userFacade;

    @RequestMapping(value = "/order")
    public String orderHome() {
        Result<UserResponse> userById = userFacade.getUserById(1);
        return "hello order";
    }
}
