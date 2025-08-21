package com.spmp.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpResponse.BodyHandler;
import java.time.chrono.IsoChronology;

/**
 * Servlet implementation class AboutServlet
 */
@WebServlet("/AboutServlet")
public class AboutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>SPMP Politeknik Mukah Sarawak");
		out.println("</title>");
		out.println("<h1>Selamat Datang</h1>");
		out.println("</head>");
		out.println("<style>");
		out.println("body {");
		out.println("    background-image: url('http://spmp.pmu.edu.my/images/backgroundsim.png');");
		out.println("    background-repeat: no-repeat;");
		out.println("    background-size: stretch;");
		out.println("}");
		out.println("</style>");
		out.println("<body>");
		out.println("<table>");
		out.println("<td>No.KP:</td>");
		out.println("<td><input></td>");
		out.println("<tr>");
		out.println("<td>Kata Laluan / No. Pend:</td> ");
		out.println("<td><input></td>");
		out.println("</tr>");
		out.println("<td><button>Login Masuk</button></td>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
@Override
public void destroy() {
	// TODO Auto-generated method stub
	super.destroy();
	System.out.print("NutsApp has been closed ");
}
}
