package pl.conaobiad;

import pl.conaobiad.dao.MealDao;
import pl.conaobiad.model.Meal;

public class AddMeal {
    public static void main(String[] args) {
        MealDao mealDao = new MealDao();
        Meal meal = new Meal( "asdas");
        mealDao.addMeal(meal);
    }
}
