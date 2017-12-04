package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.model.User;

import java.util.Set;

public interface UserService {

    Set<User> getUsers();

    User getUser(int id);

    User getUserByUserName(String username);
}
