package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


}
