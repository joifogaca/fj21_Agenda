package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo extends HttpServlet {

	private int contador = 0;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		
		contador++;
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Primeira Servlet</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>Oi mundo Servlet!</h1>");
		out.print("<h2>Contador: "+ contador +"</h2>");
		out.print("</body>");
		out.print("</html>");
	}
}
