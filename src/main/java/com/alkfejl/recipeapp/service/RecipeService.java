package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.RecipeNotFoundException;
import com.alkfejl.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Recipe addRecipe(Recipe recipe) throws RecipeNotFoundException;

    Recipe getRecipe(int id);

    void delete(int id);
}
