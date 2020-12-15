package pl.conaobiad.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.parser.api.MealUploadToDatabase;


import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet("/upload")
public class UploadJsonObjectServlet extends HttpServlet {

    @Inject
    MealUploadToDatabase mealUploadToDatabase;

    Logger logger = LoggerFactory.getLogger(pl.conaobiad.servlet.UploadJsonObjectServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("upload").equals("Upload from Url")) {
            mealUploadToDatabase.uploadFromUrl();
            logger.info("The file was successfully loaded from the url.");
        } else if(request.getParameter("upload").equals("Upload from file .json")){
            mealUploadToDatabase.uploadFromFile();
            logger.info("The file was successfully loaded from the json file.");
        }
    }
}
