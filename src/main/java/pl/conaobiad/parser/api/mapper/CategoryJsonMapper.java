package pl.conaobiad.parser.api.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Category;
import pl.conaobiad.parser.api.MealJson;

import javax.ejb.Stateless;

@Stateless
public class CategoryJsonMapper {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Category mapCategory(MealJson mealJson){
        Category category = new Category();
        category.setName(mealJson.getStrCategory());
        logger.info("Category "+category.getName()+" mapped");
        return category;
    }
}
