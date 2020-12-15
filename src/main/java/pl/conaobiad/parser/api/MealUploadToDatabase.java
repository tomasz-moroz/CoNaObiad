package pl.conaobiad.parser.api;

import pl.conaobiad.dao.MealDao;
import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.api.mapper.MealJsonMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;


@Stateless
public class MealUploadToDatabase {

    @Inject
    UrlReader urlReader;

    @Inject
    FileReader fileReader;

    @Inject
    MealJsonMapper mealJsonMapper;

    @Inject
    MealDao mealDao;

    public void uploadFromUrl() throws IOException {
        for (Meal meal:mealJsonMapper.mappedMealsFromMealJsonList(urlReader.mealApiListFromUrl())) {
            mealDao.addMeal(meal);
        }
    }
    public void uploadFromFile() throws IOException {
        for (Meal meal:mealJsonMapper.mappedMealsFromMealJsonList(fileReader.mealApiListFromFile())) {
            mealDao.addMeal(meal);
        }
    }
}
