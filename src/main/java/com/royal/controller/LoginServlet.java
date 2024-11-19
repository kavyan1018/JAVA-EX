package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet 
{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        System.out.println("Login Servlet --------------- Called !");
    
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    
        
//        if (username.equals("admin") && password.equals("admin@1234")) {
//            // This block executes if both conditions are true
//            System.out.println("Login successful!");
//            response.getWriter().write("Login successful!");
//        } else {
//            // This block executes if either or both conditions are false
//            System.out.println("Invalid credentials");
//            response.getWriter().write("Invalid credentials");
//        }
	}
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
        	doGet(request, response);
        }
}