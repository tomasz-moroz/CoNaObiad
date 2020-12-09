package pl.conaobiad.model;

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

    public Ingredient(Long id, @NotNull String name, @NotNull String measure, List<Meal> mealList) {
        this.id = id;
        this.name = name;
        this.measure = measure;
        this.mealList = mealList;
    }

    public Ingredient(@NotNull String name, @NotNull String measure) {
        this.name = name;
        this.measure = measure;
    }

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measure='" + measure + '\'' +
                ", mealList=" + mealList +
                '}';
    }
}
