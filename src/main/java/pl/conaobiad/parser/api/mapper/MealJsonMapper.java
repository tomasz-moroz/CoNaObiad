package pl.conaobiad.parser.api.mapper;

import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.api.MealJson;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.*;

@Stateless
public class MealJsonMapper {

    @Inject
    MealJsonIngredientMapper mealJsonIngredientMapper;

    @Inject
    CategoryJsonMapper categoryJsonMapper;

    public List<Meal> mappedMealsFromMealJsonList(List<MealJson>mealJsonList){
        List<Meal>meals = new ArrayList<>();
        for (MealJson jsonToMeal:mealJsonList) {
            meals.add(mapMeals(jsonToMeal));
        }
        return meals;
    }

    public Meal mapMeals(MealJson mealJson) {

        Meal meal = new Meal();

        meal.setId(Long.parseLong(mealJson.getIdMeal()));
        meal.setName(mealJson.getStrMeal());
        meal.setCategory(categoryJsonMapper.mapCategory(mealJson));
        meal.setCountryOfOrigin(mealJson.getStrArea());
        meal.setRecipe(mealJson.getStrInstructions());
        meal.setImageUrl(mealJson.getStrMealThumb());
        meal.setYoutubeLink(mealJson.getStrYoutube());
        meal.setTagsList((String) mealJson.getStrTags());
        meal.setIngredientsList(mealJsonIngredientMapper.ingredientsMapper(mealJson));

        return meal;
    }
}
