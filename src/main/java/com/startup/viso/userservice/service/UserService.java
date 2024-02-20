package com.startup.viso.userservice.service;

import com.startup.viso.userservice.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();
    User getUserById(String id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    User createUser(User user);
    User updateUser(String userId, User user);
    void deleteUser(String userId);

}
