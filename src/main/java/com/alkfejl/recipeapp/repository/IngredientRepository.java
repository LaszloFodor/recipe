package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


}
