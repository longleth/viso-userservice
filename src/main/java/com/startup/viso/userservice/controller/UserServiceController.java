package com.startup.viso.userservice.controller;

import com.startup.viso.userservice.model.User;
import com.startup.viso.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/users")
public class UserServiceController {

    private final UserService userService;

    @Autowired
    public UserServiceController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/",
            produces = "application/json", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{userId}", produces = "application/json")
    public User getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    /*@GetMapping(value = "/", produces = "application/json")
    public Optional<User> getUserByUsername(@RequestParam(value = "username", name = "username") String username) {
        return userService.getUserByUsername(username);
    }*/

    /*@GetMapping(value = "/", produces = "application/json")
    public Optional<User> getUserByEmail(@RequestParam(value = "email", name = "email") String email) {
        return userService.getUserByEmail(email);
    }*/

    @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(value = "/{userId}", consumes = "application/json", produces = "application/json")
    public User updateUser(@PathVariable String userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

}
