package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String UserName = "user123";
	String Password = "456789";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("password");

		if (userName.equals(UserName)&& userPass.equals(Password)){
			if (!userName.equals(session.getAttribute(userName))){
			session.setAttribute(userName, userName);
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>Profile Page</title>");
			out.println("<p><font face='Calibri'><h1>Login</h1></font></p>");
			out.println("<p><font face='Calibri'>Welcome " + userName + "! Have a nice day !");
			out.println("Try <a href='Logout'><b>logging out</b></a>?</font></p>");
			out.println("</html>");
			} 
			else {
				out.println("You are already logged in!");
			}
		}
		else {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("</head>");
			out.println("<title>Profile Page</title>");
			out.println("<p><font face='Calibri'><h1>Bad username or password ! Permission denied.</h1></font></p>");
			out.println("<p><font face='Calibri'>To access this page, You must be logged in. <a href='index.jsp'><b>Click here to login</b></a>.");
			out.println("</body>");
			out.println("</html>");

		}

	}

}
