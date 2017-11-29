package com.alkfejl.recipeapp.bootstrap;

import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.model.Unit;
import com.alkfejl.recipeapp.repository.IngredientRepository;
import com.alkfejl.recipeapp.repository.RecipeRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final IngredientRepository ingredientRepository;

    private final RecipeRepository recipeRepository;

    public RecipeBootstrap(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.save(getRecipe());
    }

    private Recipe getRecipe() {
        Recipe vajasKenyer = new Recipe();
        vajasKenyer.setName("vajas kenyer");
        vajasKenyer.setServing(2);
        vajasKenyer.setDescription("Ket darab kenyeret megkenunk vajjal.");
        Set<Ingredient> hozzavalok = new HashSet<>();
        hozzavalok.add(new Ingredient("kenyer", 1., Unit.db));
        hozzavalok.add(new Ingredient("vaj", 2., Unit.g));
        vajasKenyer.setIngredientSet(hozzavalok);
        return vajasKenyer;
    }

}
