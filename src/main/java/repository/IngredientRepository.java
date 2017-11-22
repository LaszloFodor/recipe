package repository;

import model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {


    Ingredient add(Ingredient ingredient);

    List<Ingredient> getAllIngredients(int id);

    Ingredient findIngredientById(int id);

    void delete(Ingredient ingredient);
}
