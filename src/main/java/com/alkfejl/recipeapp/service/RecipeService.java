package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.RecipeIsInvalidException;
import com.alkfejl.recipeapp.exception.RecipeNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe) throws RecipeIsInvalidException;

    void delete(int id) throws RecipeNotFoundException;

    Set<Recipe> getRecipes();

    Recipe findById(int id);

}
