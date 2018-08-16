package com.Learnspring.Jee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Before we start with the Flows, we need to configure application to use Spring MVC
//
//Lets do a little bit of Refactoring. 

//We need Spring MVC Framework and its dependencies. 
//Mini Step 2 : Add required jars to the project
//Spring MVC uses Front Controller Pattern -> Dispatcher Servlet. 
//Mini Step 3 : Add Dispatcher Servlet to web.xml
//DispatcherServlet needs an Spring Application Context to launch. We will create an xml (/WEB-INF/todo-servlet.xml).
//Mini Step 4: Add Spring Context

@WebServlet(urlPatterns = "/signIn")

public class LoginServlet extends HttpServlet {

	private LoginService service = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isValidUser = service.validateUser(name, password);

		if (isValidUser) {
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/views/welcome1.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}
