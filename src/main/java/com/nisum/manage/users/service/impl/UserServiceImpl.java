package com.nisum.manage.users.service.impl;

import com.nisum.manage.users.entity.Phone;
import com.nisum.manage.users.entity.User;
import com.nisum.manage.users.model.PhoneRequest;
import com.nisum.manage.users.model.UserRequest;
import com.nisum.manage.users.model.UserResponse;
import com.nisum.manage.users.repository.UserRepository;
import com.nisum.manage.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest user) {
        User userEntity = user.toEntity();
        userEntity.setCreated(LocalDateTime.now());
        userEntity.setModified(LocalDateTime.now());
        userEntity.setLastLogin(LocalDateTime.now());
        userEntity.setToken("token");
        userEntity.setActive(true);

        Set<Phone> phones = new HashSet<>();
        for (PhoneRequest phoneRequest : user.phones) {
            Phone phone = new Phone();
            phone.setCityCode(phoneRequest.getCityCode());
            phone.setCountryCode(phoneRequest.getCountryCode());

            phone.setNumber(phoneRequest.getNumber());
            phones.add(phone);
        }
        userEntity.setPhones(phones);
        userRepository.addUser(userEntity);
        return UserResponse.of(userEntity);
    }
}
