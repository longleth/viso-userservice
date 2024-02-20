package com.startup.viso.userservice.config;

import com.startup.viso.userservice.controller.UserServiceController;
import com.startup.viso.userservice.service.UserService;
import com.startup.viso.userservice.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class ServiceConfig {

    /*@Bean
    public UserService userService() {
        return new UserServiceImpl();
    }*/

    /*@Bean
    public UserServiceController controller(UserService userService) {
        UserServiceController controller = new UserServiceController();
        controller.setUserService(userService);
        return controller;
    }*/

}
