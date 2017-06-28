package com.bottle.IdentityProvider.web;

import com.bottle.IdentityProvider.model.User;
import com.bottle.IdentityProvider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by AKuzmanoski on 23/06/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 23/06/2017
 */
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(params = "username")
    public User findByUsername(@RequestParam(required = true) String username) {
        return this.userService.findByUsername(username);
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return this.userService.findOne(id);
    }
}
