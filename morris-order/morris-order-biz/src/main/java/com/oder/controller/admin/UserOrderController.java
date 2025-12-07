package com.oder.controller.admin;

import com.user.api.facade.UserFacade;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class UserOrderController {
    @Resource
    private UserFacade userFacade;
    @RequestMapping(value = "/order/{id}")
    public String orderHome(@PathVariable(value = "id") Integer id){
        userFacade.getUserById(id);
        return "hello order";
    }
}
