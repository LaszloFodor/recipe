package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Service
public interface UserService {

    Set<User> getUsers();

    User getUser(int id);

    User getUserByUserName(String username);
}
