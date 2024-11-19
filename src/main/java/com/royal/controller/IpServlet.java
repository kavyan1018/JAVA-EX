package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IpServlet
 */
//@WebServlet("/IpServlet")
public class IpServlet extends HttpServlet {
		static int VisiterCounter = 0;
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			
			VisiterCounter++;
			PrintWriter out = response.getWriter();
//			out.print ("Hello World");
			
			String clientIp = request. getRemoteAddr();

//			out.print("Client Ip : " + clientIp);
			
//			System.out.println("clientIp : " + clientIp);
			
//			System.out.println("visterCounter : " + );
			
			System.out.println(clientIp +": " + VisiterCounter);

	}

}
