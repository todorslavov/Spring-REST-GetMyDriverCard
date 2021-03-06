package com.telerikacademy.drivingcardserver.controllers;

import com.telerikacademy.drivingcardserver.models.CardApplication;
import com.telerikacademy.drivingcardserver.models.ImageModel;
import com.telerikacademy.drivingcardserver.models.User;
import com.telerikacademy.drivingcardserver.services.userservice.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public User getUserByEmail (@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{email}")
    public User updateUserCardApplication(@PathVariable String email,
                                          @RequestBody CardApplication cardApplication) {
        return userService.updateUserCardApplication(email, cardApplication);
    }

    @PostMapping()
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @GetMapping("/pending/{email}")
    public CardApplication getPendingApplication(@PathVariable String email) {
        return userService.getUserPendingApplication(email);
    }

    @GetMapping("/applications/{email}")
    public List<CardApplication> getApplications (@PathVariable String email) {
        return userService.getApplications(email);
    }
}
