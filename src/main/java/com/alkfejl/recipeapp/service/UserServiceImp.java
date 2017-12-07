package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.UserNotValidException;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.model.User;
import com.alkfejl.recipeapp.repository.RecipeRepository;
import com.alkfejl.recipeapp.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

import static com.alkfejl.recipeapp.model.User.Role.USER;

@Service
@SessionScope
@Data
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    private User user;

    @Autowired
    private RecipeRepository recipeRepository;

    public User login(User user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
    }

    public User register(User user) {
        user.setRole(USER);
        this.user = userRepository.save(user);
        return user;
    }

    public boolean isValid(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    /*@Override
    public Set<Recipe> getRecipes(User user) {
        return user.getRecipeSet();
    }*/

}
