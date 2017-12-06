package com.alkfejl.recipeapp.api;

import com.alkfejl.recipeapp.exception.UserNotValidException;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.model.User;
import com.alkfejl.recipeapp.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("api/user")
public class UserApiController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public UserApiController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    //@Role({USER, ADMIN})
    @GetMapping
    public ResponseEntity<User> user() {
        if (userServiceImp.isLoggedIn()) {
            return ResponseEntity.ok(userServiceImp.getUser());
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userServiceImp.login(user));
        } catch (UserNotValidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/logout")
    public ResponseEntity logout(@RequestBody User user) {
        this.userServiceImp.setUser(null);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImp.register(user));
    }

    @GetMapping("/recipes")
    public ResponseEntity<Set<Recipe>> getRecipes(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImp.getRecipes(user));
    }



}
