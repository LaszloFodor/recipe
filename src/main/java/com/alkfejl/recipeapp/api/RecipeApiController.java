package com.alkfejl.recipeapp.api;

import com.alkfejl.recipeapp.exception.RecipeIsInvalidException;
import com.alkfejl.recipeapp.exception.RecipeNotFoundException;
import com.alkfejl.recipeapp.model.Ingredient;
import com.alkfejl.recipeapp.model.Recipe;
import com.alkfejl.recipeapp.service.RecipeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("api/recipe")
public class RecipeApiController {

    private final RecipeServiceImp recipeServiceImp;

    @Autowired
    public RecipeApiController(RecipeServiceImp recipeServiceImp) {
        this.recipeServiceImp = recipeServiceImp;
    }

    @PostMapping("/add")
    public ResponseEntity<Recipe> addRecipe(@RequestBody Recipe recipe) {
        try {
            return ResponseEntity.ok(recipeServiceImp.addRecipe(recipe));
        } catch (RecipeIsInvalidException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id) {
        try {
            this.recipeServiceImp.delete(id);
            return  ResponseEntity.ok().build();
        } catch (RecipeNotFoundException e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/getall")
    public ResponseEntity getRecipes() {
        return ResponseEntity.ok(recipeServiceImp.getRecipes());
    }
}
