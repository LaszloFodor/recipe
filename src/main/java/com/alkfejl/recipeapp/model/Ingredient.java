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

    @OneToOne(fetch = FetchType.EAGER)
    private Unit unit;


}
