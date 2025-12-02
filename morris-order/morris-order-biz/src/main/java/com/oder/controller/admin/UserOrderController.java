package com.oder.controller.admin;


import com.oder.common.UserRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class UserOrderController {
    private final UserRestClient userRestClient;
    @RequestMapping(value = "/order")
    public String orderHome(){
        userRestClient.getUserById(1);
        return "hello order";
    }
}
