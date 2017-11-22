package repository;

import model.Recipe;

import java.util.List;

public interface RecipeRepository {
    public Recipe findRecipeById(int id) {
    }

    public List<Recipe> getAllRecipes() {
        return allRecipes;
    }

    public Recipe add(Recipe recipe) {
    }
}
