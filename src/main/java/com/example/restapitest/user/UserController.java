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

    @GetMapping(path = "/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userService.getUserById(userId);
    }

    /*

        GET - http://localhost:8080/api/v1/user/1

     */

    @PostMapping(path = "/create")
    public void setUser(@RequestBody User user) {
        userService.createUser(user);
    }

    /*

        POST - http://localhost:8080/api/v1/user/create

        {
            "name": "Karunasena",
            "email": "karunasena@gmail.com",
            "dob": "1998-01-17"
        }

     */

    @DeleteMapping(path = "/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    /*

        DELETE - http://localhost:8080/api/v1/user/delete/1

     */

    @PutMapping(path = "/update/{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestBody User user
    ) {
        userService.updateUser(userId, user);
    }

    /*

        PUT - http://localhost:8080/api/v1/user/update/1

        {
            "name": "Karunasena",
            "email": "karunasena@gmail.com",
            "dob": "1998-01-17"
        }

     */

}
