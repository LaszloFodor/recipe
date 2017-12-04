package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String name);

    Optional<User>  findByUsernameAndPassword(String username, String password);
}
