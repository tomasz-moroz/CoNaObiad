package pl.conaobiad.servlet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.model.Meal;
import pl.conaobiad.parser.FileDataHandler;
import pl.conaobiad.parser.RecipeUploadedFileNotFound;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@MultipartConfig
@WebServlet("/json-upload")
public class MealUploadServlet extends HttpServlet {

    @Inject
    private FileDataHandler fileDataHandler;

    Logger logger = LoggerFactory.getLogger(pl.conaobiad.servlet.MealUploadServlet.class);

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part jsonFile = request.getPart("meals");
        String fileUrl = "";
        try {
            fileUrl = "/meals/" + fileDataHandler.dataUploadHandler(jsonFile);
        } catch (RecipeUploadedFileNotFound recipeUploadedFileNotFound) {
            logger.info(recipeUploadedFileNotFound.getMessage());
        }
        Meal meal = new Meal();
        meal.setImageUrl(fileUrl);

    }

}
