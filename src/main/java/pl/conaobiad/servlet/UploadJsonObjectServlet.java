package pl.conaobiad.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.dao.MealDao;
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
    @Inject
    MealDao mealDao;


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("upload").equals("Upload from Url")) {
            mealUploadToDatabase.uploadFromUrl();

        } else if (request.getParameter("upload").equals("Upload from file .json")) {
            mealDao.uploadFromFile();

        }
    }
}
