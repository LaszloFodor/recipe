package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    //Optional<Recipe> saveAll(List<Recipe> recipes);
    Optional<Recipe> findByName(String name);
}
