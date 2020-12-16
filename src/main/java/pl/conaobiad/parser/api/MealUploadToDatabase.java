package pl.conaobiad.parser.api;

import pl.conaobiad.dao.MealDao;
import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.api.mapper.MealJsonMapper;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.IOException;

@Transactional
@RequestScoped
public class MealUploadToDatabase {

    @Inject
    UrlReader urlReader;

    @Inject
    MealJsonMapper mealJsonMapper;

    @EJB
    MealDao mealDao;

    public void uploadFromUrl() throws IOException {
        for (Meal meal:mealJsonMapper.mappedMealsFromMealJsonList(urlReader.mealApiListFromUrl())) {
            mealDao.addMeal(meal);
        }
    }
    public void uploadFromFile() throws IOException {
        FileReader fileReader = new FileReader();
        for (Meal meal: mealJsonMapper.mappedMealsFromMealJsonList(fileReader.mealApiListFromFile())) {
            mealDao.addMeal(meal);
        }
    }

    public static void main(String[] args) throws IOException {
        MealUploadToDatabase mealUploadToDatabase = new MealUploadToDatabase();
        mealUploadToDatabase.uploadFromFile();
    }
}
