package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.model.User;
import com.alkfejl.recipeapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Set<User> getUsers() {
        Set<User> users = new HashSet<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username).get();
    }
}
