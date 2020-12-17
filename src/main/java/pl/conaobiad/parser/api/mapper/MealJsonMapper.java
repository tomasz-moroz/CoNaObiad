package pl.conaobiad.parser.api.mapper;

import pl.conaobiad.dto.MealDto;
import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.api.FileReader;
import pl.conaobiad.parser.api.MealJson;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.*;

@Stateless
public class MealJsonMapper {

    @EJB
    static
    MealJsonIngredientMapper mealJsonIngredientMapper;

    @EJB
    static CategoryJsonMapper categoryJsonMapper;

    public static List<Meal> mappedMealsFromMealJsonList(List<MealJson>mealJsonList){
        List<Meal>meals = new ArrayList<>();
        for (MealJson jsonToMeal:mealJsonList) {
            meals.add(mapMeals(jsonToMeal));
        }
        return meals;
    }

    public static Meal mapMeals(MealJson mealJson) {

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
        meal.setSource(mealJson.getStrSource());
        meal.setCustom(false);
        meal.setApproved(true);
        return meal;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        for (Meal meal:mappedMealsFromMealJsonList(fileReader.mealApiListFromFile())) {
            System.out.println(meal.getName());
        }
    }
}
