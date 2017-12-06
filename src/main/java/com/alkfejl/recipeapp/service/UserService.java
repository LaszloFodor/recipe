package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.UserNotValidException;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Service
public interface UserService {

    User login(User user) throws UserNotValidException;

    User register(User user);

    boolean isValid(User user);

    boolean isLoggedIn();

    Set<Recipe> getRecipes(User user);

}
