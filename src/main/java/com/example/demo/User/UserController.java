package com.example.demo.User;

import com.example.demo.model.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserTable> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/add_user")
    public void createUser(@RequestBody UserTable user) {
        userService.addUser(user);

    }

    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable Long id) {
        if (userService.findUserById(id).isPresent())
            userService.deleteUser(id);
        else throw new IllegalStateException("User not found");

    }

    @PutMapping("/update_user/{id}")
    public void updateUser(@PathVariable Long id, @RequestParam(required = false) String name) {
        userService.updateUser(id, name);

    }
}