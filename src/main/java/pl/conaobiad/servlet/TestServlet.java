package pl.conaobiad.servlet;


import pl.conaobiad.dto.MealDto;

import pl.conaobiad.service.MealService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/test")
public class TestServlet extends HttpServlet {

    @Inject
    MealService mealService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        String name = req.getParameter("name");
        String recipe = req.getParameter("recipe");
        String country = req.getParameter("country");

        MealDto meal = new MealDto();

        meal.setName(name);
        meal.setRecipe(recipe);
        meal.setCountryOfOrigin(country);

        mealService.addMeal(meal);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(String.format("Person saved: %s", meal.toString()));
    }
}