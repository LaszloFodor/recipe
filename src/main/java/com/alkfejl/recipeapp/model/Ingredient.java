package com.alkfejl.recipeapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "ingredientId")
    private Set<RecipeIngredient> recipeIngredient;

    @Enumerated(value = EnumType.STRING)
    private Unit unit;

    public Ingredient() {}

    public Ingredient(int id, String name, Unit unit) {
        this.name = name;
        this.unit = unit;
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

    public Set<RecipeIngredient> getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(Set<RecipeIngredient> recipe) {
        this.recipeIngredient = recipe;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
