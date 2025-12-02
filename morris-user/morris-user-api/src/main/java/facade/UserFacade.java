package facade;

import common.api.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import response.UserResponse;

@FeignClient(value = "${application.user.name}",contextId = "UserFacade")
public interface UserFacade {
    @GetMapping("/{id}")
    Result<UserResponse> getUserById(@PathVariable(value = "id") Integer id);
}
