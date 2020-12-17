package pl.conaobiad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.dao.MealDao;
import pl.conaobiad.dto.MealDto;
import pl.conaobiad.model.Meal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;


@RequestScoped
public class MealService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    MealDao mealDao;

    @Inject
    MessageService messageService;

    public MealDto addMeal(MealDto mealDto){
        Meal meal = mealDto.dtoToMeal(mealDto);
        mealDao.addMeal(meal);
        return  mealDto.mealToDto(meal);
    }

    public void editMeal(MealDto mealDto) {
        Meal meal = MealDto.dtoToMeal(mealDto);
        mealDao.editMeal(meal);
    }

    public MealDto getMealByName(String  name) {
        Meal meal = mealDao.getMealByName(name);
        if(meal != null){
            return MealDto.mealToDto(meal);
        }
        return null;
    }

    public MealDto getMealById(Long id) {
        Meal meal = mealDao.getMealById(id);
        if (meal != null) {
            return MealDto.mealToDto(meal);
        }
        return null;
    }

    public void deleteMealById(Long id) {
        if (mealDao.getMealList().stream().anyMatch(meal -> meal.getId().equals(id))){
            mealDao.deleteMealById(id);
            logger.info("Drink has been deleted");
        }
    }

    public void deleteMealByName (String name){
        if (mealDao.getMealList().stream().anyMatch(meal -> meal.getName().equals(name))){
            mealDao.deleteMealByName(name);
            logger.info("Meal has been deleted");
            messageService.leaveMessage(1L, "Meal was deleted.");
        } else {
            messageService.leaveMessage(1L, "Nothing has happened");
        }
    }

    public List<MealDto> getMealList() {
        return mealDao.getMealList().stream().map(MealDto::mealToDto).collect(Collectors.toList());
    }
}
