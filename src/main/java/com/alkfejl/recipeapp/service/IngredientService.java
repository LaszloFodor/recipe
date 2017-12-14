package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.IngredientIsInvalidException;
import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;

import java.util.Set;

public interface IngredientService {

    Ingredient addIngredient(Ingredient ingredient) throws IngredientIsInvalidException;

    void delete(int id) throws IngredientNotFoundException;

    Set<Ingredient> getRecipes();

    Ingredient findById(int id);


}
