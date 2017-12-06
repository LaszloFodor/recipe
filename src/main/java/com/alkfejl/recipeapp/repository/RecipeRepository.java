package com.alkfejl.recipeapp.repository;

import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findByName(String name);

    //Optional<Set<Ingredient>> getByIngredientSet(Recipe recipe);
}
