package pl.conaobiad.model;

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

    public Meal(Long id, @NotNull String name, Category category, @NotNull String countryOfOrigin, @NotNull String recipe, String imageUrl, String youtubeLink, String tagsList, List<Ingredient> ingredientsList, String source, @NotNull boolean isCustom, @NotNull boolean isApproved) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.countryOfOrigin = countryOfOrigin;
        this.recipe = recipe;
        this.imageUrl = imageUrl;
        this.youtubeLink = youtubeLink;
        this.tagsList = tagsList;
        this.ingredientsList = ingredientsList;
        this.source = source;
        this.isCustom = isCustom;
        this.isApproved = isApproved;
    }

    public Meal() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getTagsList() {
        return tagsList;
    }

    public void setTagsList(String tagsList) {
        this.tagsList = tagsList;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isCustom() {
        return isCustom;
    }

    public void setCustom(boolean custom) {
        isCustom = custom;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", recipe='" + recipe + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", tagsList='" + tagsList + '\'' +
                ", ingredientsList=" + ingredientsList +
                ", source='" + source + '\'' +
                ", isCustom=" + isCustom +
                ", isApproved=" + isApproved +
                '}';
    }
}
