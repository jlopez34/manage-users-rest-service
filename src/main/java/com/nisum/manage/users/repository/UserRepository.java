package com.nisum.manage.users.repository;

import com.nisum.manage.users.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    User addUser(User user);

    List<User> getUsers();

    User findById(int id);

    User update(User user, int id);

    void delete(int id);
}
