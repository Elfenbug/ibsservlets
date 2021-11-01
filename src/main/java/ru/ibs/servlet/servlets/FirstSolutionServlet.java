package ru.ibs.servlet.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.ibs.servlet.Book;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstSolutionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final Book user = new Book(1, "Glen Cook", "The Black Company");
        final String json = new ObjectMapper().writeValueAsString(user);
        resp.getWriter().write(json);
    }
}
