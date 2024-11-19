package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConfigertextServlet extends HttpServlet{
			
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");

			ServletContext context = getServletContext();


				String lang1 = context.getInitParameter("lang1"); 
				String lang2 = context.getInitParameter("lang2"); 
				String lang3 = context.getInitParameter("lang3"); 

				PrintWriter out = response.getWriter();
				
				out.print("lang 1 :" + lang1 + "<br>");
				out.print("lang 2 :" + lang2 + "<br>"); 
				out.print("lang 3 :" + lang3 + "<br>");
			
		}
		
	}