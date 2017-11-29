package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.repository.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

public class RecipeServiceImp implements RecipeService {


    private final RecipeRepository recipeRepository;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
