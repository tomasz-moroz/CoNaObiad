package pl.conaobiad.parser.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class FileReader {

    public  List<MealJson> mealApiListFromFile() throws IOException {
        List<MealJson> mealApiList = new ArrayList<>();
        for (MealJson meal : readerFromFile().getMeals()) {
            mealApiList.add(meal);
        }
        return mealApiList;
    }

    public MealsJson  readerFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MealsJson mealApi = objectMapper.readValue(new File("src/main/resources/Data/test.json"), MealsJson.class);
        return mealApi;
    }
}
