package webapp;

//package com.Learnspring.J2EE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 *
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 *
 * Web Server responds with Http Response
 */

// Servlet is a Java programming language class
// used to extend the capabilities of servers
// that host applications accessed by means of
// a request-response programming model.

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet

{
	// here the web.xml and pom takes care of everyhting.. Added tomcat plugin to
	// deploy on server and web.xml takes the login servlet by default
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		/** simple generating an html response manually. throws IOException */
		// step 1
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Yahoo!!!!!!!!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("My First Servlet");
		out.println("</body>");
		out.println("</html>");

		// always theviews are given more priority.

		// Step 2
		// step 3 adding query params and taking them to view.
		//request.setAttribute("name", request.getParameter("name"));

		//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);// throws ServletException
	}

	// Step 4:POST method, here we have a single url serving both for a get and a
	// post request.
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", request.getParameter("name"));
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
	}

}
