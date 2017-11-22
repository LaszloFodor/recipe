package repository;

import model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    Recipe findRecipeById(int id);

    List<Recipe> getAllRecipes();

    Recipe add(Recipe recipe);

    void delete(Recipe recipe);
}
