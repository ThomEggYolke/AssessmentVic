package my.gov.sarawak.feedback;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();

	        out.println("<!DOCTYPE html>");
	        out.println("<html><head><title>Login Page</title></head><body>");
	        out.println("<h2>Digital Feedback Portal - Login</h2>");
	        out.println("<form method='post' action='login'>");
	        out.println("Username: <input type='text' name='username' required><br><br>");
	        out.println("Password: <input type='password' name='password' required><br><br>");
	        out.println("<input type='submit' value='Login'>");
	        out.println("</form>");
	        out.println("</body></html>");
	    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            
            response.sendRedirect("feedback?user=" + username);
        } else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Login Failed</title></head><body>");
            out.println("<h3>Login Failed! Invalid username or password.</h3>");
            out.println("<a href='login'>Try again</a>");
            out.println("</body></html>");
        }
	}

}
