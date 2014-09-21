package servlet_jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHello extends HttpServlet {

	private static final long serialVersionUID = -4963281376433410919L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>\n" + 
				"<head></head>\n" + 
				"<body>\n" + 
				"<h3>This content is being rendered by SayHello Servlet!</h3>\n" + 
				"</body>\n" + 
				"</html>");
	}

}
