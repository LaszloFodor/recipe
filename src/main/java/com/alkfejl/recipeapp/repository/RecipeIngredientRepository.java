package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Integer>{

    Optional<RecipeIngredient> findByRecipeId(int recipeId);

    Optional<RecipeIngredient> findByIngredientId(int ingredientId);

    @Transactional
    void deleteByIngredientId(int ingredientId);

    @Transactional
    void deleteByRecipeId(int recipeId);

}
