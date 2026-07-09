package com.example.lecture13.servlet;

import java.io.IOException;
import java.util.List;

import com.example.lecture13.model.User;
import com.example.lecture13.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService;

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        if (id == null || name == null || email == null || phone == null) {
            resp.setStatus(404);
            resp.setContentType("application/json");
            resp.getWriter().write(
                    "{\n" + " \"message\" : \"User fields are missing\"\n" + "}");
        }

        User user = new User(id, name, email, phone);
        User createdUser = userService.createUser(user);

        resp.setStatus(201);
        resp.setContentType("application/json");
        resp.getWriter().write(
                "{\n" + " \"message\" : \"User added successfully\"\n" + "}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        if (id == null) {
            List<User> allUsers = userService.getUsers();
        }

        User getUser = userService.getUserById(id);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
