package pl.conaobiad.parser.api.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Ingredient;
import pl.conaobiad.parser.api.FileReader;
import pl.conaobiad.parser.api.MealJson;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.*;

@Stateless
public class MealJsonIngredientMapper {

    private static Logger logger = LoggerFactory.getLogger(MealJsonIngredientMapper.class.getName());

    public static List<Ingredient> ingredientsMapper(MealJson mealJson){
        return mapIngredients(mapIngredients(mealJson));
    }

    public static Map<String, String> mapIngredients (MealJson mealJson){
        Map<String, String> mapOfIngredients = new HashMap<>();

        mapOfIngredients.put(mealJson.getStrIngredient1(), mealJson.getStrMeasure1());
        mapOfIngredients.put(mealJson.getStrIngredient2(), mealJson.getStrMeasure2());
        mapOfIngredients.put(mealJson.getStrIngredient3(), mealJson.getStrMeasure3());
        mapOfIngredients.put(mealJson.getStrIngredient4(), mealJson.getStrMeasure4());
        mapOfIngredients.put(mealJson.getStrIngredient5(), mealJson.getStrMeasure5());
        mapOfIngredients.put(mealJson.getStrIngredient6(), mealJson.getStrMeasure6());
        mapOfIngredients.put(mealJson.getStrIngredient7(), mealJson.getStrMeasure7());
        mapOfIngredients.put(mealJson.getStrIngredient8(), mealJson.getStrMeasure8());
        mapOfIngredients.put(mealJson.getStrIngredient9(), mealJson.getStrMeasure9());
        mapOfIngredients.put(mealJson.getStrIngredient10(), mealJson.getStrMeasure10());
        mapOfIngredients.put(mealJson.getStrIngredient11(), mealJson.getStrMeasure11());
        mapOfIngredients.put(mealJson.getStrIngredient12(), mealJson.getStrMeasure12());
        mapOfIngredients.put(mealJson.getStrIngredient13(), mealJson.getStrMeasure13());
        mapOfIngredients.put(mealJson.getStrIngredient14(), mealJson.getStrMeasure14());
        mapOfIngredients.put(mealJson.getStrIngredient15(), mealJson.getStrMeasure15());
        mapOfIngredients.put(mealJson.getStrIngredient16(), mealJson.getStrMeasure16());
        mapOfIngredients.put(mealJson.getStrIngredient17(), mealJson.getStrMeasure17());
        mapOfIngredients.put(mealJson.getStrIngredient18(), mealJson.getStrMeasure18());
        mapOfIngredients.put(mealJson.getStrIngredient19(), mealJson.getStrMeasure19());
        mapOfIngredients.put(mealJson.getStrIngredient20(), mealJson.getStrMeasure20());

        while (mapOfIngredients.values().remove(null));
        while (mapOfIngredients.values().remove(" "));
        while (mapOfIngredients.values().remove(""));

        return mapOfIngredients;
    }
    public static List<Ingredient> mapIngredients(Map<String, String> mapIngredients) {

        List<Ingredient> ingredients = new ArrayList<>();

        mapIngredients.entrySet().forEach(i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(i.getKey());
            ingredient.setMeasure(i.getValue());
            ingredients.add(ingredient);
        });
        logger.info("Ingredients {} added.", mapIngredients);
        return ingredients;
    }
}
