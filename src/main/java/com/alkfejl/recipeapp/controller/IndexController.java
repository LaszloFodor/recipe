package com.alkfejl.recipeapp.controller;


import com.alkfejl.recipeapp.service.IngredientService;
import com.alkfejl.recipeapp.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @RequestMapping({"","/", "/index"})
    public String getIndexPage(Model model) {

        //model.addAttribute("recipe");
        return "index";
    }

}
