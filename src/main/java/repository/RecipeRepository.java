package repository;

import model.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Optional<Recipe> findRecipeById(int id);

    Optional<List<Recipe>> getAllRecipes();

    Optional<Recipe> add(Recipe recipe);
}
