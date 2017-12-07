package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.repository.IngredientRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@SessionScope
@Data
public class IngredientServiceImp implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient ingredient;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) throws IngredientNotFoundException {
        if(isValid(ingredient)) {
            return this.ingredient = ingredientRepository.findByName(ingredient.getName()).get();
        }
        throw new IngredientNotFoundException();
    }

    @Override
    public void delete(int id) {
        ingredientRepository.delete(id);
    }

    @Override
    public Set<Ingredient> getRecipes() {
        Set<Ingredient> recipeSet = new HashSet<>();
        ingredientRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Ingredient findById(int id) {
        Optional<Ingredient> recipeOptional = ingredientRepository.findById(id);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe not found!");
        }
        return recipeOptional.get();
    }

    private boolean isValid(Ingredient ingredient) {
        return ingredientRepository.findByName(ingredient.getName()).isPresent();
    }
}
