package ru.ibs.servlet.servlets;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ru.ibs.servlet.Book;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class SecondSolutionServlet extends HttpServlet {
    private final Gson gson = new Gson();
    private final String pathname = "D:\\IBS\\Servlets\\book.json";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (JsonReader reader = new JsonReader(new FileReader(pathname))) {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.print((Book) gson.fromJson(reader, Book.class));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        try (Writer writer = new FileWriter(pathname)) {
            new Gson().toJson(new Book(1, "Stephen King", "Dark Tower"), writer);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        try (Writer writer = new FileWriter(pathname)) {
            new Gson().toJson(new Book(1, "Glen Cook", "The Black Company"), writer);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("application/json");
        File fileToDelete = new File(pathname);
        if (fileToDelete.delete()) {
            System.out.println("File deleted");
        } else {
            System.out.println("Operation failed");
        }
    }
}
