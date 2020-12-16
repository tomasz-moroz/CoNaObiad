package pl.conaobiad.parser;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.dao.CategoryDao;
import pl.conaobiad.mappers.CategoryMapper;
import pl.conaobiad.mappers.MealMapper;
import pl.conaobiad.model.Category;
import pl.conaobiad.service.MealService;
import pl.conaobiad.service.MessageService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.io.File;
import java.util.Optional;

@Transactional
@RequestScoped
public class FileParserService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Inject
    private ParserService parserService;

    @Inject
    private MealService mealService;

    @Inject
    private MessageService messageService;

    @EJB
    private MealMapper mealMapper;

    @EJB
    private CategoryMapper categoryMapper;

    @EJB
    private CategoryDao categoryDao;

  /*  public Object parseDataToDatabase(File json) {
        List<MealApi> mealApis = (List<MealApi>) parserService.parseFile(json);
        Integer size = mealApis.size();
        Integer count = 0;
        for (MealApi mealApi : mealApis) {
            if (mealService.getMealList().stream().noneMatch(meal -> meal.getName().equals(mealApi.getName()))) {
                count++;
                Category category = Optional.ofNullable(categoryDao.findCategoryByName(mealApi.getCategory()))
                        .orElseGet(() -> categoryMapper.mapCategory(mealApi));
                category.getMealList().add(mealMapper.mapMeals(mealApi, category));
                categoryDao.updateCategory(category);
            }
        }
        logger.info("{} was parsed from {}", count, size);
        messageService.leaveMessage(1L, count + " items was parsed from " + size);

        return new Object();
    }*/
}
