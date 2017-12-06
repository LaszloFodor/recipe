package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient) throws IngredientNotFoundException;

    void delete(int id);

}
