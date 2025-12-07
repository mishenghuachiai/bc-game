package com.user.api.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
}
