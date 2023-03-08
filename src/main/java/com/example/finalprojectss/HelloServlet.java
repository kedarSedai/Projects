package com.example.finalprojectss;

import Model.College;
import Service.UserService;

import java.io.*;
import java.util.List;
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

        if (page.equalsIgnoreCase("newUsers")) {

            College college = new College();

            college.setUserName(req.getParameter("userName"));
            college.setPassword(req.getParameter("password"));
            college.setLocation(req.getParameter("location"));
            new UserService().insertUser(college);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);


        }

        if (page.equalsIgnoreCase("register")) {
            RequestDispatcher requestDispatch = req.getRequestDispatcher("register.jsp");
            requestDispatch.forward(req, resp);
        }

        if (page.equalsIgnoreCase("index")) {
            RequestDispatcher requestDispatch = req.getRequestDispatcher("index.jsp");
            requestDispatch.forward(req, resp);
        }

        if (page.equalsIgnoreCase("login")) {
            String userName = req.getParameter("userName");
            String password = req.getParameter("password");

            College college = new UserService().loginUser(userName, password);

            if (college != null) {
                HttpSession session = req.getSession();
                session.setAttribute("userName", userName);
                RequestDispatcher requestDispatch = req.getRequestDispatcher("dash.jsp");
                requestDispatch.forward(req, resp);

            } else {
                RequestDispatcher requestDispatch = req.getRequestDispatcher("index.jsp");
                requestDispatch.include(req, resp);
            }
        }

        if (page.equalsIgnoreCase("userList")) {

            College college = new College();
            List<College> collegeList = new UserService().getUserList();
            System.out.println(collegeList);


            req.setAttribute("collegeList", collegeList);
            req.setAttribute("college", college);

            RequestDispatcher requestDispatch = req.getRequestDispatcher("userList.jsp");
            requestDispatch.forward(req, resp);
        }

    }

    public void destroy() {
    }
}