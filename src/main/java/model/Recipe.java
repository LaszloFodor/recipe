package model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.awt.*;

@Entity
@Table(name = "RECIPES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Recipe extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String recipeName;

    @Column(nullable = true)
    private Image image;

    @Column(nullable = false, length = 200)
    private String description;
}
