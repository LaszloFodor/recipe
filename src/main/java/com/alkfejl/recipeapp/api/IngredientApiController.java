package com.alkfejl.recipeapp.api;

import com.alkfejl.recipeapp.exception.IngredientIsInvalidException;
import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.service.IngredientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/ingredient")
public class IngredientApiController {

    private final IngredientServiceImp ingredientServiceImp;

    @Autowired
    public IngredientApiController(IngredientServiceImp ingredientServiceImp) {
        this.ingredientServiceImp = ingredientServiceImp;
    }

    @PostMapping("/add")
    public ResponseEntity<Ingredient> addIngredient(@RequestBody Ingredient ingredient) {
        try {
            return ResponseEntity.ok(ingredientServiceImp.addIngredient(ingredient));
        } catch (IngredientIsInvalidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id) {
        try {
            this.ingredientServiceImp.delete(id);
            return ResponseEntity.ok().build();
        } catch (IngredientNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getall")
    public ResponseEntity getRecipes() {
        return ResponseEntity.ok(ingredientServiceImp.getRecipes());
    }

}
