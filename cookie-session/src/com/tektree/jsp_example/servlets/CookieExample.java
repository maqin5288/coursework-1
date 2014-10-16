package com.tektree.jsp_example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieExample
 */
@WebServlet("/cookie")
public class CookieExample extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieExample() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("This is GET from theh cookie class");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie usernameCookie = new Cookie("username", request.getParameter("username"));
        usernameCookie.setMaxAge(60);
        response.addCookie(usernameCookie);
        Cookie passwordCookie = new Cookie("password", request.getParameter("password"));
        passwordCookie.setMaxAge(60);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
        PrintWriter writer = response.getWriter();
        writer.println("This is POST from theh cookie class");
    }

}
