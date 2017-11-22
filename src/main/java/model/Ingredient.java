package model;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Ingredient extends BaseEntity {

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private double measurement;

    @Column(nullable = false)
    private Unit unit;

    public enum Unit {
        GRAMM, DKG, KG, DECILITER, MILILITER, LITER
    }
}
