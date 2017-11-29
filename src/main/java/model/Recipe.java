package model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "RECIPES")
@Data
public class Recipe extends BaseEntity{

    private String recipeName;

    private double time;

    private String description;

    private int servings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredientList;

}
