package com.nisum.manage.users.model;

import com.nisum.manage.users.entity.User;
import com.opengamma.strata.collect.ArgChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class UserRequest implements Serializable {

    public String name;
    public String email;
    public String password;
    public List<PhoneRequest> phones;

    public UserRequest() {
    }

    public User toEntity() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public static UserRequest of(User user) {
        ArgChecker.notNull(user, "user");
        UserRequest dto = new UserRequest();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

}
