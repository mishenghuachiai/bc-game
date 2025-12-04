package com.user.api.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
}
