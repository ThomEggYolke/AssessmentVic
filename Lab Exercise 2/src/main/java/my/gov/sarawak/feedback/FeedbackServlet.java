package my.gov.sarawak.feedback;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
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
    	 String user = request.getParameter("user"); // from LoginServlet redirect

         response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();

         out.println("<!DOCTYPE html>");
         out.println("<html><head><title>Feedback Form</title></head><body>");
         out.println("<h2>Welcome, " + user + "! Please submit your feedback.</h2>");
         out.println("<form method='post' action='feedback'>");
         out.println("Name: <input type='text' name='name' required><br><br>");
         out.println("Email: <input type='email' name='email' required><br><br>");
         out.println("Feedback Type: <select name='type'>");
         out.println("<option value='Complaint'>Complaint</option>");
         out.println("<option value='Suggestion'>Suggestion</option>");
         out.println("<option value='Inquiry'>Inquiry</option>");
         out.println("</select><br><br>");
         out.println("Description:<br>");
         out.println("<textarea name='description' rows='4' cols='50' required></textarea><br><br>");
         out.println("<input type='submit' value='Submit Feedback'>");
         out.println("</form>");
         out.println("</body></html>");
     }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String description = request.getParameter("description");

       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Validation
        boolean valid = true;
        String errorMsg = "";

        if (name == null || name.trim().isEmpty() ||
            email == null || email.trim().isEmpty() ||
            description == null || description.trim().isEmpty()) {
            valid = false;
            errorMsg += "All fields must be filled.<br>";
        }

        if (email != null && !Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", email)) {
            valid = false;
            errorMsg += "Invalid email format.<br>";
        }

        if (description != null && description.length() < 10) {
            valid = false;
            errorMsg += "Description must be at least 10 characters long.<br>";
        }

        if (!valid) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Validation Error</title></head><body>");
            out.println("<h3>Validation Failed:</h3>");
            out.println("<p style='color:red'>" + errorMsg + "</p>");
            out.println("<a href='feedback?user=admin'>Go Back</a>");
            out.println("</body></html>");
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Feedback Received</title></head><body>");
            out.println("<h2>Feedback Submitted Successfully!</h2>");
            out.println("<p><strong>Name:</strong> " + name + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
            out.println("<p><strong>Type:</strong> " + type + "</p>");
            out.println("<p><strong>Description:</strong> " + description + "</p>");
            out.println("<br><a href='login'>Logout</a>");
            out.println("</body></html>");
	
	//doGet(request, response);
	
    }
}
}
