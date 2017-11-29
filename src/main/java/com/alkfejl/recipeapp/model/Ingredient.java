package com.alkfejl.recipeapp.model;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Data
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private double amount;

    @ManyToOne
    private Recipe recipe;

    @Enumerated(value = EnumType.STRING)
    private Unit unit;


    public Ingredient(String name, double d, Unit unit) {
        this.name = name;
        this.amount = d;
        this.unit = unit;
    }
}
