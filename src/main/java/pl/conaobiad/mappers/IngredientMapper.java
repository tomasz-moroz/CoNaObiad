package pl.conaobiad.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Ingredient;
import pl.conaobiad.parser.MealApi;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class IngredientMapper {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    public List<Ingredient> mapIngredients(MealApi mealApi) {

        List<Ingredient> ingredients = new ArrayList<>();

        mealApi.getIngredients().entrySet().forEach(i -> {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(i.getKey());
            ingredient.setMeasure(i.getValue());
            ingredients.add(ingredient);
        });
        logger.info("Ingredients {} added.", mealApi);
        return ingredients;
    }
}
