package com.yumamur.firstapidb;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    private String postMethod(
            @RequestBody User user
    ) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    private String deleteMethod(
            @PathVariable(value = "id")
            String id,
            @RequestBody
            UserDeleteRequest request
    ) {
        return userService.clearRepository(Integer.parseInt(id), request);
    }
}