package pl.conaobiad.parser.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public MealsJson readerFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MealsJson mealApi = objectMapper.readValue(new File("src/main/resources/Data/a.json"), MealsJson.class);
        return mealApi;
    }

    public List<MealJson> mealApiListFromFile() throws IOException {
        List<MealJson> mealApiList = new ArrayList<>();
        for (MealJson meal : readerFromFile().getMeals()) {
            mealApiList.add(meal);
        }
        return mealApiList;
    }
}
