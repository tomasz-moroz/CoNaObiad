package pl.conaobiad.mappers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Category;
import pl.conaobiad.parser.MealApi;

import javax.ejb.Stateless;

@Stateless
public class CategoryMapper {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public Category mapCategory(MealApi mealApi){
        Category category = new Category();
        category.setName(mealApi.getCategory());
        logger.info("Category "+category.getName()+" mapped");
        return category;
    }
}
