package com.example.restapitest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /*

        GET - http://localhost:8080/api/v1/user/all

     */

    @PostMapping(path = "/create")
    public void setUser(@RequestBody User user) {
        userService.createUser(user);
    }

    /*

        POST - http://localhost:8080/api/v1/user/create

        {
            "name": "Sandaruwan",
            "email": "sandaruwan@gmail.com",
            "dob": "1999-02-18"
        }

     */

}
