package com.user.api.facade;



import com.user.api.common.api.Result;
import com.user.api.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="${spring.application.name}",url = "http://localhost:8080",contextId = "UserFacade")
public interface UserFacade {
    @GetMapping("/{id}")
    Result<UserResponse> getUserById(@PathVariable(value = "id") Integer id);
}
