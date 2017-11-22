package service;

import exception.RecipeIdNotValidException;
import lombok.Data;
import model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import repository.RecipeRepository;

import java.util.List;

@Service
@SessionScope
@Data
public class RecipeService {


    @Autowired
    private RecipeRepository recipeRepository;

    private Recipe recipe;

    public Recipe getRecipeById(int id) throws RecipeIdNotValidException {
        if(recipeRepository.findRecipeById(id) != null){
            return this.recipe = recipeRepository.findRecipeById(id);
        }
        throw new RecipeIdNotValidException();
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public Recipe addRecipe(Recipe recipe){
        return recipeRepository.add(recipe);
    }

}
