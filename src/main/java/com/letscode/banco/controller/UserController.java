package com.letscode.banco.controller;

import com.letscode.banco.model.User;
import com.letscode.banco.request.UserRequest;
import com.letscode.banco.response.UserResponse;
import com.letscode.banco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public UserResponse create (@RequestBody UserRequest userRequest) {
        User user = userService.create(userRequest);
        return new UserResponse(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Integer id) {
        Optional<User> user =userService.findById(id);
        return new UserResponse(user.get());
    }
}
