package pl.conaobiad.parser.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
@Stateless
public class UrlReader {

    public List<MealJson> mealApiListFromUrl() throws IOException {
        List<MealJson> mealApiList = new ArrayList<>();
        for (URL url : urlBuilder()) {
            readerFromUrl(url);
            for (MealJson meal : readerFromUrl(url).getMeals()) {
                mealApiList.add(meal);
            }
        }
        return mealApiList;
    }

    public MealsJson readerFromUrl(URL url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        MealsJson mealApi = objectMapper.readValue(url, MealsJson.class);
        return mealApi;
    }



    public List<URL> urlBuilder() throws MalformedURLException {
        String chars[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "v", "w", "y"};
        List<URL> urls = new ArrayList<>();
        for (String character : chars) {
            String newUrl = "https://www.themealdb.com/api/json/v1/1/search.php?f=" + character;
            URL url = new URL(newUrl);
            urls.add(url);
        }
        return urls;
    }



}
/*    String chars[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};*/
