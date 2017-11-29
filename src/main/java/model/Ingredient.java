package model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "INGREDIENTS")
@Data
public class Ingredient extends BaseEntity {

    private String name;

    private double amount;

    @ManyToOne
    private Recipe recipe;

    @Enumerated(value = EnumType.ORDINAL)
    private Unit unit;

    public enum Unit {
        g, dkg, kg, l, dl, cl, ml, db
    }

}
