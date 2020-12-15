package pl.conaobiad.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.conaobiad.freemarker.TemplateProvider;
import pl.conaobiad.parser.api.FileReader;
import pl.conaobiad.parser.api.UrlReader;

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
    TemplateProvider templateProvider;
    @Inject
    FileReader fileReader;
    @Inject
    UrlReader urlReader;

    Logger logger = LoggerFactory.getLogger(pl.conaobiad.servlet.UploadJsonObjectServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("upload").equals("Upload from Url")) {
            urlReader.mealApiListFromUrl();
        } else if(request.getParameter("upload").equals("Upload from file .json")){
            fileReader.mealApiListFromFile();
        }
    }
}
