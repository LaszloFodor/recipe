package com.alkfejl.recipeapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    private int serving;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipeId")
    private Set<RecipeIngredient> ingredientSet;

    @ManyToOne
    private User user;

    public Recipe() {

    }

    public Recipe(int id, String name, String description, Set<RecipeIngredient> ingredientSet) {
        this.name = name;
        this.description = description;
        this.ingredientSet = ingredientSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<RecipeIngredient> getRecipeIngredientSet() {
        return ingredientSet;
    }

    public void setRecipeIngredientSet(Set<RecipeIngredient> ingredientSet) {
        this.ingredientSet = ingredientSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
