package pl.conaobiad.servlet;


import pl.conaobiad.dto.CategoryDto;
import pl.conaobiad.dto.IngredientDto;
import pl.conaobiad.dto.MealDto;

import pl.conaobiad.service.MealService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Inject
    MealService mealService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String country = req.getParameter("country");
        String recipe = req.getParameter("recipe");
        String imageUrl = req.getParameter("imageUrl");
        String youtubeLink = req.getParameter("youtubeLink");
        String tagsList = req.getParameter("tagsList");

        String ingredient1 = req.getParameter("ingredient1");
        String measure1 = req.getParameter("measure1");

        String ingredient2 = req.getParameter("ingredient2");
        String measure2 = req.getParameter("measure2");

        String source = req.getParameter("source");


        MealDto mealDto = new MealDto();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category);
        Map<String, String> mapOfIngredients = new HashMap<>();
        List<IngredientDto> listOfIngredients = new ArrayList<>();

        mealDto.setName(name);
        mealDto.setCategory(categoryDto);
        mealDto.setCountryOfOrigin(country);
        mealDto.setRecipe(recipe);
        mealDto.setImageUrl(imageUrl);
        mealDto.setYoutubeLink(youtubeLink);
        mealDto.setTagsList(tagsList);

        mapOfIngredients.put(ingredient1, measure1);
        mapOfIngredients.put(ingredient2, measure2);
        mapOfIngredients.entrySet().forEach(i -> {
            IngredientDto ingredientDto = new IngredientDto();
            ingredientDto.setName(i.getKey());
            ingredientDto.setMeasure(i.getValue());
            listOfIngredients.add(ingredientDto);
        });

        mealDto.setIngredientList(listOfIngredients);

        mealDto.setSource(source);
        mealDto.setCustom(false);
        mealDto.setApproved(true);

        mealService.addMeal(mealDto);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(String.format("Person saved: %s", mealDto.toString()));
    }
}