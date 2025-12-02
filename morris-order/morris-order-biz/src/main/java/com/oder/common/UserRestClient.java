package com.oder.common;

import common.api.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import response.UserResponse;

@RequiredArgsConstructor
@Component
public class UserRestClient {

    private final RestClient restClient;
    private static final String BASE_URL = "http://localhost:8080";
    public UserRestClient() {
        this.restClient = RestClient.builder()
                .baseUrl(BASE_URL)                    // 生产：http://user-service
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public UserResponse getUserById(Integer id) {
        return restClient.get()
                .uri("/api/v1/users/{id}", id)
                .retrieve()
                .body(new ParameterizedTypeReference<Result<UserResponse>>() {})
                .getData();   // 提取 data 字段
    }
}
