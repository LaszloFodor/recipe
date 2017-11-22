package service;


import exception.IngredientIdNotValidException;
import lombok.Data;
import model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import repository.IngredientRepository;

import java.util.List;

@Service
@Data
@SessionScope
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient ingredient;

    private List<Ingredient> ingredientList;


    public Ingredient getIngredientById(int id) throws IngredientIdNotValidException {
        if(ingredientRepository.findIngredientById(id) != null){
            return this.ingredient = ingredientRepository.findIngredientById(id);
        }
        throw new IngredientIdNotValidException();
    }

    public List<Ingredient> getAllIngredientOfRecipe(int id) {
        return this.ingredientList = ingredientRepository.getAllIngredients(id);
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return this.ingredient = ingredientRepository.add(ingredient);
    }

    public void deleteIngredient(Ingredient ingredient){
        ingredientRepository.delete(ingredient);
    }
}
