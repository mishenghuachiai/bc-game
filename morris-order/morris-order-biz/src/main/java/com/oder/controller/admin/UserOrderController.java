package com.oder.controller.admin;

import com.user.api.facade.UserFacade;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class UserOrderController {
    @Resource
    private UserFacade userFacade;
    @RequestMapping(value = "/order")
    public String orderHome(){
        userFacade.getUserById(1);
        return "hello order";
    }
}
