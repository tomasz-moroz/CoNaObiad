package pl.conaobiad.parser.api;


import pl.conaobiad.dao.MealDao;


import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.api.mapper.MealJsonMapper;

import javax.ejb.Stateless;

import javax.inject.Inject;

import java.util.*;
import java.io.IOException;



@Stateless
public class MealUploadToDatabase {

    @Inject
    UrlReader urlReader;
    @Inject
    MealDao mealDao;
    @Inject
    FileReader fileReader;

    public void uploadFromUrl() throws IOException {
        for (Meal meal : MealJsonMapper.mappedMealsFromMealJsonList(urlReader.mealApiListFromUrl())) {
            mealDao.addMeal(meal);
        }
    }

    public void uploadFromFile() throws IOException {
        for (Meal meal : MealJsonMapper.mappedMealsFromMealJsonList(fileReader.mealApiListFromFile())) {
            mealDao.addMeal(meal);
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
