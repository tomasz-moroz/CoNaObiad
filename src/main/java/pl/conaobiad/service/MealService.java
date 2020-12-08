package pl.conaobiad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.dao.MealDao;
import pl.conaobiad.dto.MealDto;
import pl.conaobiad.model.Meal;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequestScoped
public class MealService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @EJB
    MealDao mealDao;

    @Inject
    MessageService messageService;

    public MealDto addMeal(MealDto mealDto){
        if(mealDao.getMealList().stream().noneMatch(meal -> meal.getName().equals(mealDto.getName()))){
            Meal meal = MealDto.dtoToMeal(mealDto);
            messageService.leaveMessage(1L, "Meal was added");
            return MealDto.mealToDto(mealDao.addMeal(meal));
        } else {
            messageService.leaveMessage(1L, "Nothing has happened, please change name.");
            return null;
        }
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
