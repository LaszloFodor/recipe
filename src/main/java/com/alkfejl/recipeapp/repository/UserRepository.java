package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String name);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
