package pl.conaobiad.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class MealDeserializer extends JsonDeserializer<MealApi> {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Override
    public MealApi deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        Map<String, String> ingredients = new HashMap<>();

        MealApi mealApi = new MealApi();
        JsonNode tree = p.readValueAsTree();

        String[] errors = {"null", "", " "};

        for(int index = 1; index < 21; index++){

            index = (char) index;

            JsonNode ingredientNode = tree.get("strIngredient" + index);

            if (ingredientNode == null) {
                break;
            }

            String trim = ingredientNode.asText().trim();

            for(String error : errors) {
                if (!trim.equals(error)&&!trim.isEmpty()) {
                    ingredients.put(tree.get("strIngredient"+index).asText().trim(),
                            tree.get("strMeasure"+index).asText().trim());
                }
            }
        }
        mealApi.setId(tree.get("idMeal").asLong());
        mealApi.setName(tree.get("strMeal").asText());
        mealApi.setCategory(tree.get("strCategory").asText());
        mealApi.setCountryOfOrigin(tree.get("strArea").asText());
        mealApi.setRecipe(tree.get("strInstructions").asText());
        mealApi.setImageUrl(tree.get("strMealThumb").asText());
        mealApi.setYoutubeLink(tree.get("strYoutube").asText());
        mealApi.setMealTags(tree.get("strTags").asText());
        mealApi.setIngredients(ingredients);

        logger.info("Deserialization data from file");
        return  mealApi;
    }

}
