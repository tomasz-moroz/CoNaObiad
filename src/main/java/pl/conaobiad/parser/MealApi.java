package pl.conaobiad.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties({"strDrinkAlternate", "dateModified"})
@JsonDeserialize(using = MealDeserializer.class)
public class MealApi {

    @JsonProperty("idMeal")
    private Long id;
    @JsonProperty("strMeal")
    private String name;
    @JsonProperty("strCategory")
    private String category;
    @JsonProperty("strArea")
    private String countryOfOrigin;
    @JsonProperty("strInstructions")
    private String recipe;
    @JsonProperty("strMealThumb")
    private String imageUrl;
    @JsonProperty("strYoutube")
    private String youtubeLink;
    @JsonProperty("strTags")
    private String mealTags;
    @JsonProperty("strSource")
    private String source;
    private Map<String, String> ingredients = new HashMap<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public String getMealTags() {
        return mealTags;
    }

    public String getSource() {
        return source;
    }

    public Map<String, String> getIngredients() {
        return ingredients;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public void setMealTags(String mealTags) {
        this.mealTags = mealTags;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setIngredients(Map<String, String> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "MealApi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", recipe='" + recipe + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", mealTags='" + mealTags + '\'' +
                ", source='" + source + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
