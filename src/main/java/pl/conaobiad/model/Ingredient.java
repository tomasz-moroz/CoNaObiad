package pl.conaobiad.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.ArrayList;

@NamedQueries({
        @NamedQuery(
                name = Ingredient.FIND_INGREDIENT_BY_NAME,
                query = "SELECT distinct i.name FROM Ingredient i WHERE i.name in :names"),
        @NamedQuery(
                name = Ingredient.GET_INGREDIENT_LIST,
                query = "SELECT distinct i FROM Ingredient i")
})

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ingredient", indexes = {@Index(name = "idx_name", columnList = "name")})
public class Ingredient {

    public static final String FIND_INGREDIENT_BY_NAME = "Ingredient.findIngredientByName";
    public static final String GET_INGREDIENT_LIST = "Ingredient.getIngredientList";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    @NotNull
    private String name;

    @Column(name = "measure")
    @NotNull
    private String measure;

    @ManyToMany(mappedBy = "ingredientsList")
    private List<Meal> mealList = new ArrayList<>();
}
