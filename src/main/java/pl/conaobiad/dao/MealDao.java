package pl.conaobiad.dao;

import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.api.FileReader;
import pl.conaobiad.parser.api.mapper.MealJsonMapper;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;

@Stateless
public class MealDao {

    @PersistenceContext
    EntityManager entityManager;

    public Meal addMeal(Meal meal) {
        entityManager.persist(meal);
        return meal;
    }

    public Meal editMeal(Meal meal) {
        return entityManager.merge(meal);
    }

    public Meal getMealByName(String name) {
        TypedQuery<Meal> query = entityManager.createNamedQuery(Meal.GET_MEAL_BY_NAME, Meal.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    public Meal getMealById(Long id) {
        return entityManager.find(Meal.class, id);
    }

    public Boolean deleteMealById(Long id) {
        Meal meal = getMealById(id);
        if (meal != null) {
            entityManager.remove(meal);
            return true;
        }
        return null;
    }

    public Boolean deleteMealByName(String name) {
        Meal meal = getMealByName(name);
        if (meal != null) {
            entityManager.remove(meal);
            return true;
        }
        return false;
    }

    public List<Meal> getMealList() {
        TypedQuery<Meal> query = entityManager.createNamedQuery(Meal.GET_MEAL_LIST, Meal.class);
        return query.getResultList();
    }

    public void uploadFromFile() throws IOException {
        FileReader fileReader = new FileReader();
        for (Meal meal : MealJsonMapper.mappedMealsFromMealJsonList(fileReader.mealApiListFromFile())) {
            addMeal(meal);
        }
    }

}
