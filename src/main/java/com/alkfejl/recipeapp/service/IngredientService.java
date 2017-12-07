package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;

import java.util.Set;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient) throws IngredientNotFoundException;

    void delete(int id);

    Set<Ingredient> getRecipes();

    Ingredient findById(int id);


}
