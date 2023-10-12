package com.demo.sihenni;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/conca") // add @WebServlet annotation, and comment the configuration tags on web.xml file
public class AddServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//only post method will be used in the index.html file 
	//when using the doPost method in the servlet.
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String fNameReq = req.getParameter("fname");
		String lNameReq = req.getParameter("lname");
		
//		String fullName = fNameReq + " " + lNameReq;
		
//		PrintWriter out = res.getWriter();
//		out.println("The Full Name is : " + fullName);
		
		
		// using session
//		HttpSession session = req.getSession();
//		session.setAttribute("fullName", fullName);
//		System.out.println("AddServlet : " + fullName);
//		System.out.println("The Attribute : " + session.getAttribute("fullName"));

		
		//using Cookies
		//Cookie cookie = new Cookie("fullName", URLEncoder.encode( fullName, "UTF-8" )); //URLEncoder.encode( fullName, "UTF-8" )
		Cookie cookieFName = new Cookie("fname", fNameReq);
		Cookie cookieLName = new Cookie("lname", lNameReq);
		res.addCookie(cookieFName);
		res.addCookie(cookieLName);
		res.sendRedirect("square"); //sending data from servlet to servlet with sendRedirect 
														  // & URL Rewriting
		
//		req.setAttribute("fullName", fullName);
		
//		RequestDispatcher rd = req.getRequestDispatcher("square");
//		rd.forward(req, res);
		
	}

}
