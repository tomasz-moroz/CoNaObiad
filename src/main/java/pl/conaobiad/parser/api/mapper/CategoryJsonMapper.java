package pl.conaobiad.parser.api.mapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.dto.CategoryDto;
import pl.conaobiad.model.Category;
import pl.conaobiad.parser.api.FileReader;
import pl.conaobiad.parser.api.MealJson;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public class CategoryJsonMapper {
    private static Logger logger = LoggerFactory.getLogger(CategoryJsonMapper.class.getName());

    public static Category mapCategory(MealJson mealJson){
        Category category = new Category();
        category.setName(mealJson.getStrCategory());
        logger.info("Category "+category.getName()+" mapped");
        return category;
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader();
        for (MealJson mealJson:fileReader.mealApiListFromFile()) {
            System.out.println(mapCategory(mealJson).getName());
        }
    }
}
