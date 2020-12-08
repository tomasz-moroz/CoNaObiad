package pl.conaobiad.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(value = {
        @NamedQuery(
                name = Meal.GET_MEAL_LIST,
                query = "SELECT m FROM Meal m"),
        @NamedQuery(
                name = Meal.GET_MEAL_BY_NAME,
                query = "SELECT m FROM Meal m WHERE m.name =:name")
})

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table
public class Meal {

    public static final String GET_MEAL_LIST = "Meal.getMealList";
    public static final String GET_MEAL_BY_NAME = "Meal.getMealByName";

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, length = 100)
    @NotNull
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "category_id")
    private Category category;

    @Column(name = "Country_of_origin")
    @NotNull
    private String countryOfOrigin;

    @Column(name = "recipe", length = 5000)
    @NotNull
    private String recipe;

    @Column(length = 2000)
    private String imageUrl;

    @Column(length = 2000, name = "YouTube_link")
    private String youtubeLink;

    @Column(name = "Tags")
    private String tagsList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "meal_to_ingredient",
            joinColumns = {@JoinColumn(name = "meal_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")}
    )
    private List<Ingredient> ingredientsList = new ArrayList<>();

    @Column(length = 2000)
    private String source;

    @Column(name = "is_custom")
    @NotNull
    private boolean isCustom;

    @Column(name = "is_approved")
    @NotNull
    private boolean isApproved;


}
