package com.alkfejl.recipeapp.service;

import com.alkfejl.recipeapp.exception.IngredientIsInvalidException;
import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.model.RecipeIngredient;
import com.alkfejl.recipeapp.repository.IngredientRepository;
import com.alkfejl.recipeapp.repository.RecipeIngredientRepository;
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

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    private Ingredient ingredient;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) throws IngredientIsInvalidException {
        if(isValidIngredient(ingredient)) {
            ingredientRepository.save(ingredient);
            return ingredientRepository.findById(ingredient.getId()).get();
        }
        throw new IngredientIsInvalidException("The given data is invalid!");
    }

    @Override
    public void delete(int id) throws IngredientNotFoundException {
        if(isValid(findById(id))) {
            ingredientRepository.delete(id);
            recipeIngredientRepository.deleteByIngredientId(id);
        }
        throw new IngredientNotFoundException("No ingredient is found by given id!");
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

    private boolean isValidIngredient(Ingredient ingredient) {
        if(ingredient != null) {
            if(ingredient.getName() != null && ingredient.getUnit() != null) {
                if(!ingredient.getName().equals("") && !ingredient.getUnit().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
}
