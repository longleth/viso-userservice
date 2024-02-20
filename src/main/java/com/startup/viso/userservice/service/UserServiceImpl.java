package com.startup.viso.userservice.service;

import com.startup.viso.userservice.config.ServiceConfig;
import com.startup.viso.userservice.model.User;
import com.startup.viso.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ServiceConfig serviceConfig;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setServiceConfig(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUserById(String id) {
        return userRepository.getReferenceById(id);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    /**
     * @param userId
     * @param user
     * @return
     */
    @Override
    public User updateUser(String userId, User user) {
        User current = userRepository.getReferenceById(userId);
        current.updateTo(user, (source, target) -> {
            if (!target.getUsername().equalsIgnoreCase(source.getUsername()))
                source.setUsername(target.getUsername());
            if (!target.getPassword().equals(source.getPassword()))
                source.setPassword(target.getPassword());
            if (!target.getEmail().equalsIgnoreCase(source.getEmail())) {
                source.setEmail(target.getEmail());
            }
        });
        return userRepository.save(current);
    }

    /**
     * @param userId
     */
    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
