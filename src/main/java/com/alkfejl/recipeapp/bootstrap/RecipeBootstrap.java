package com.alkfejl.recipeapp.bootstrap;

import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.repository.IngredientRepository;
import com.alkfejl.recipeapp.repository.RecipeRepository;
import com.alkfejl.recipeapp.repository.UnitRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;s

public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final IngredientRepository ingredientRepository;

    private final RecipeRepository recipeRepository;

    private final UnitRepository unitRepository;

    public RecipeBootstrap(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, UnitRepository unitRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.unitRepository = unitRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {


        List<Recipe> recipes = new ArrayList<>();


        

    }

}
