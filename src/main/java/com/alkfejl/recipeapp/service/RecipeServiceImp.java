package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.RecipeNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.repository.RecipeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Service
@SessionScope
@Data
public class RecipeServiceImp implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    private Recipe recipe;

    @Override
    public Recipe addRecipe(Recipe recipe) throws RecipeNotFoundException {
        if (isValid(recipe)) {
            return this.recipe = recipeRepository.findByName(recipe.getName()).get();
        }
        throw new RecipeNotFoundException();
    }

    private boolean isValid(Recipe recipe) {
        return recipeRepository.findByName(recipe.getName()).isPresent();
    }

    @Override
    public void delete(int id) {
        recipeRepository.delete(id);
    }

    /*
    @Override
    public Set<Ingredient> getIngredients(Recipe recipe) {
        return recipeRepository.getByIngredientSet(recipe).get();
    }
    */
}
