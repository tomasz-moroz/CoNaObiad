package pl.conaobiad.parser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import pl.conaobiad.model.Category;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

}
