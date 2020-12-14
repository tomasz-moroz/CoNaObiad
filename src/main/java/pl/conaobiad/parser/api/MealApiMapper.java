package pl.conaobiad.parser.api;


import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Ingredient;

import java.lang.reflect.Method;
import java.util.*;

public class MealApiMapper  {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public static Map<String, String> mapIngredients (MealJson mealApi){
        Map<String, String> mapOfIngredients = new HashMap<>();

        mapOfIngredients.put(mealApi.getStrIngredient1(), mealApi.getStrMeasure1());
        mapOfIngredients.put(mealApi.getStrIngredient2(), mealApi.getStrMeasure2());
        mapOfIngredients.put(mealApi.getStrIngredient3(), mealApi.getStrMeasure3());
        mapOfIngredients.put(mealApi.getStrIngredient4(), mealApi.getStrMeasure4());
        mapOfIngredients.put(mealApi.getStrIngredient5(), mealApi.getStrMeasure5());
        mapOfIngredients.put(mealApi.getStrIngredient6(), mealApi.getStrMeasure6());
        mapOfIngredients.put(mealApi.getStrIngredient7(), mealApi.getStrMeasure7());
        mapOfIngredients.put(mealApi.getStrIngredient8(), mealApi.getStrMeasure8());
        mapOfIngredients.put(mealApi.getStrIngredient9(), mealApi.getStrMeasure9());
        mapOfIngredients.put(mealApi.getStrIngredient10(), mealApi.getStrMeasure10());
        mapOfIngredients.put(mealApi.getStrIngredient11(), mealApi.getStrMeasure11());
        mapOfIngredients.put(mealApi.getStrIngredient12(), mealApi.getStrMeasure12());
        mapOfIngredients.put(mealApi.getStrIngredient13(), mealApi.getStrMeasure13());
        mapOfIngredients.put(mealApi.getStrIngredient14(), mealApi.getStrMeasure14());
        mapOfIngredients.put(mealApi.getStrIngredient15(), mealApi.getStrMeasure15());
        mapOfIngredients.put(mealApi.getStrIngredient16(), mealApi.getStrMeasure16());
        mapOfIngredients.put(mealApi.getStrIngredient17(), mealApi.getStrMeasure17());
        mapOfIngredients.put(mealApi.getStrIngredient18(), mealApi.getStrMeasure18());
        mapOfIngredients.put(mealApi.getStrIngredient19(), mealApi.getStrMeasure19());
        mapOfIngredients.put(mealApi.getStrIngredient20(), mealApi.getStrMeasure20());

        while (mapOfIngredients.values().remove(null));
        while (mapOfIngredients.values().remove(" "));
        while (mapOfIngredients.values().remove(""));

        return mapOfIngredients;
    }
}
