package com.nisum.manage.users.service;

import com.nisum.manage.users.model.UserRequest;
import com.nisum.manage.users.model.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
