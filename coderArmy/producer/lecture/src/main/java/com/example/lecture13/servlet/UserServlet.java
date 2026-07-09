package com.example.lecture13.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
    public void init() throws ServletException {
        // Critical Fix: Initialize the service so it isn't null
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if (idParam == null || name == null || email == null || mobile == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{ \"message\" : \"User fields are missing\" }");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);
            User user = new User(id, name, email, mobile);
            userService.createUser(user);

            resp.setStatus(HttpServletResponse.SC_CREATED);
            out.write("{ \"message\" : \"User added successfully\" }");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{ \"message\" : \"Invalid ID format\" }");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if (idParam == null) {
            // Get all users
            List<User> allUsers = userService.getUsers();
            StringBuilder json = new StringBuilder("[");
            for (int i = 0; i < allUsers.size(); i++) {
                User u = allUsers.get(i);
                json.append(String.format("{\"id\":%d, \"name\":\"%s\", \"email\":\"%s\", \"mobile\":\"%s\"}",
                        u.getId(), u.getName(), u.getEmail(), u.getMobile()));
                if (i < allUsers.size() - 1) json.append(",");
            }
            json.append("]");
            
            resp.setStatus(HttpServletResponse.SC_OK);
            out.write(json.toString());
        } else {
            // Get specific user
            try {
                Integer id = Integer.parseInt(idParam);
                User user = userService.getUserById(id);
                
                if (user != null) {
                    resp.setStatus(HttpServletResponse.SC_OK);
                    out.write(String.format("{\"id\":%d, \"name\":\"%s\", \"email\":\"%s\", \"mobile\":\"%s\"}",
                            user.getId(), user.getName(), user.getEmail(), user.getMobile()));
                } else {
                    resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    out.write("{ \"message\" : \"User not found\" }");
                }
            } catch (NumberFormatException e) {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{ \"message\" : \"Invalid ID format\" }");
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if (idParam == null || name == null || email == null || mobile == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{ \"message\" : \"User fields are missing\" }");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);
            User userReq = new User(id, name, email, mobile);
            User updatedUser = userService.updateUser(id, userReq);

            if (updatedUser != null) {
                resp.setStatus(HttpServletResponse.SC_OK);
                out.write("{ \"message\" : \"User updated successfully\" }");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.write("{ \"message\" : \"User not found\" }");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{ \"message\" : \"Invalid ID format\" }");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        if (idParam == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{ \"message\" : \"ID parameter is missing\" }");
            return;
        }

        try {
            Integer id = Integer.parseInt(idParam);
            String result = userService.deleteUser(id);
            
            if (result.equals("User deleted successfully")) {
                resp.setStatus(HttpServletResponse.SC_OK);
                out.write("{ \"message\" : \"User deleted successfully\" }");
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                out.write("{ \"message\" : \"User not found\" }");
            }
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{ \"message\" : \"Invalid ID format\" }");
        }
    }
}