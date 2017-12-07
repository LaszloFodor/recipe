package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.UserNotValidException;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.model.User;
import java.util.Set;


public interface UserService {

    User login(User user) throws UserNotValidException;

    User register(User user);

    boolean isValid(User user);

    boolean isLoggedIn();

    //Set<Recipe> getRecipes(User user);

}
