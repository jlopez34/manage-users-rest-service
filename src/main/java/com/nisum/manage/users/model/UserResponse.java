package com.nisum.manage.users.model;

import com.nisum.manage.users.entity.User;
import com.opengamma.strata.collect.ArgChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class UserResponse implements Serializable {

    private long id;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private String token;
    private boolean isActive;

    public UserResponse() {
    }

    public static UserResponse of(User user) {
        ArgChecker.notNull(user, "user");
        UserResponse dto = new UserResponse();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
