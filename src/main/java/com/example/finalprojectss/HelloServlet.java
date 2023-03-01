package com.example.finalprojectss;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/user")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String page = req.getParameter("page");

        if (page.equalsIgnoreCase("register")) {
            RequestDispatcher requestDispatch = req.getRequestDispatcher("register.jsp");
            requestDispatch.forward(req, resp);
        }

        if(page.equalsIgnoreCase("index")){
            RequestDispatcher requestDispatch = req.getRequestDispatcher("index.jsp");
            requestDispatch.forward(req, resp);
        }

        if (page.equalsIgnoreCase("login")) {
            String name = req.getParameter("userName");
            String password = req.getParameter("password");

            System.out.println("userName is: " + name + " password is: " + password);
        }
    }

    public void destroy() {
    }
}