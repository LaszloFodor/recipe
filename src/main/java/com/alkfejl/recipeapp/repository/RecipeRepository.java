package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    //Optional<Recipe> saveAll(List<Recipe> recipes);
    Optional<Recipe> findByName(String name);
}
