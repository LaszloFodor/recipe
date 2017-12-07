package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Optional<Ingredient> findByName(String name);

    Optional<Ingredient> findById(int id);

}
