package pl.conaobiad.parser.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class UrlReader {

    public static MealsApi readerFromUrl(URL url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MealsApi mealApi = objectMapper.readValue(url, MealsApi.class);
        return mealApi;
    }
    public static MealsApi readerFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MealsApi mealApi = objectMapper.readValue(new File("src/main/resources/Data/a.json"), MealsApi.class);
        return mealApi;
    }


    public static List<URL> urlBuilder() throws MalformedURLException {
        String chars[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "v", "w", "y"};
        List<URL> urls = new ArrayList<>();
        for (String character : chars) {
            String newUrl = "https://www.themealdb.com/api/json/v1/1/search.php?f=" + character;
            URL url = new URL(newUrl);
            urls.add(url);
        }
        return urls;
    }

    public static List<MealApi> mealApiListFromUrl() throws IOException {
        List<MealApi> mealApiList = new ArrayList<>();
        for (URL url : urlBuilder()) {
            readerFromUrl(url);
                for (MealApi meal : readerFromUrl(url).getMeals()) {
                    mealApiList.add(meal);
                }
        }
        return mealApiList;
    }

    public static List<MealApi> mealApiListFromFile() throws IOException {
        List<MealApi> mealApiList = new ArrayList<>();
        for (MealApi meal : readerFromFile().getMeals()) {
            mealApiList.add(meal);
        }
        return mealApiList;
    }


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < mealApiListFromFile().size(); i++) {
            System.out.println(
                    mealApiListFromFile().get(i).getStrMeal()+"\n");
        }
    }
}
/*    String chars[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};*/
