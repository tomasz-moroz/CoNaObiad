package pl.conaobiad.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Category;
import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.MealApi;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class MealMapper {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    private IngredientMapper ingredientMapper;

    public Meal mapMeals(MealApi mealApi, Category category) {

        Meal meal = new Meal();

        meal.setId(mealApi.getId());
        meal.setName(mealApi.getName());
        meal.setCategory(category);
        meal.setCountryOfOrigin(mealApi.getCountryOfOrigin());
        meal.setRecipe(mealApi.getRecipe());
        meal.setImageUrl(mealApi.getImageUrl());
        meal.setYoutubeLink(mealApi.getYoutubeLink());
        meal.setTagsList(mealApi.getMealTags());
        meal.getIngredientsList().addAll(ingredientMapper.mapIngredients(mealApi));

        return meal;
    }
}
