package servlet_jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlRewrite extends HttpServlet {

	private static final long serialVersionUID = -8898592318192916986L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println("You are " + request.getParameter("person"));
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String person = request.getParameter("person");
		String result = "";
		if(person == null || "".equals(person)) {
			result = "Please enter your name as the system does not know you.";
		} else {
			result = "Welcome " + person;
		}
		PrintWriter writer = response.getWriter();
		writer.println("<html>\n" + 
				"<head></head>\n" + 
				"<body>\n" + 
				result + "<br />" +
				"<form action=\"urlRewriteServlet\" method=\"POST\">\n" + 
				"Who are you?<br />\n" + 
				"<input name=\"person\">\n" + 
				"<input type=\"submit\">\n" + 
				"</form>\n" + 
				"</body>\n" + 
				"</html>");
	}
	
}
