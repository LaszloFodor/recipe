package com.alkfejl.recipeapp.api;

import com.alkfejl.recipeapp.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserApiController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public UserApiController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    public ResponseEntity<User> user() {
        if(userServiceImp.isLoggedIn()){
            return ResponseEntity.ok(userServiceImp.getUser());
        }
    }



}
