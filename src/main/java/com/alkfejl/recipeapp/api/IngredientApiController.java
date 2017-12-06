package com.alkfejl.recipeapp.api;

import com.alkfejl.recipeapp.exception.IngredientNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.service.IngredientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/ingredients")
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
        } catch (IngredientNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id) {
        this.ingredientServiceImp.delete(id);
        return  ResponseEntity.ok().build();
    }

}
