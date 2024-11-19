package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TableServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        for (int i = 1; i <= 10; i++) {
            out.println("5 * " + i + " = " + (5 * i) + "<br>");
        }
        
    }
}

