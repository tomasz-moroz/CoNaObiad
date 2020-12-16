package pl.conaobiad.servlet;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import pl.conaobiad.freemarker.TemplateProvider;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/start-servlet")
public class StartServlet extends HttpServlet {
    @Inject
    TemplateProvider templateProvider;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, Object> root = new HashMap<>();

        Template template = templateProvider.getTemplate(getServletContext(), "test-meal-upload.ftlh");
        Writer out = response.getWriter();

        try {
            template.process(root, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
