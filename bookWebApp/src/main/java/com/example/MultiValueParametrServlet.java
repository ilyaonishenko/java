package com.example;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class MultiValueParametrServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest requset,HttpServletResponse response)
		throws ServletException,IOException{
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("<!DOCTYPE html>\r\n")
				.append("<html>\r\n")
				.append("<head>\r\n")
				.append("<title>Hello User App</title>\r\n")
				.append("</head>\r\n")
				.append("<body>\r\n")
				.append("<form action=\"checkboxes\"method=\"POST\">\r\n")
				.append("Select fruits<br>\r\n")
				.append("<input type=\"checkbox\" name=\"fruit\" value=\"Banana\"/>")
				.append(" Banana<br/>\r\n")
				.append("<input type=\"checkbox\" name=\"fruit\" value=\"Apple\"/>")
				.append(" Apple<br/>\r\n")
				.append("<input type=\"checkbox\" name=\"fruit\" value=\"Orange\"/>")
				.append(" Orange<br/>\r\n")
				.append("<input type=\"checkbox\" name=\"fruit\" value=\"Guava\"/>")
				.append(" Guava<br/>\r\n")
				.append("<input type=\"checkbox\" name=\"fruit\" value=\"Kiwi\"/>")
				.append(" Kiwi<br/>\r\n")
				.append("<input type=\"submit\" value=\"Submit\"/>\r\n")
				.append("</form>\r\n")
				.append("</body>\r\n")
				.append("</html>\r\n");
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException,IOException{
			String[] fruits = request.getParameterValues("fruit");
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.append("<!DOCTYPE html>\r\n")
				.append("<html>\r\n")
				.append("<head>\r\n")
				.append("<title>Hello User App</title>\r\n")
				.append("</head>\r\n")
				.append("<body>\r\n")
				.append("Your selections</br>\r\n");
			if (fruits==null)
				writer.append("You didn't match anything</br>\r\n");
			else{
				writer.append("<ul>\r\n");
				for (String s:fruits)
					writer.append("<li>").append(s).append("</li>\r\n");
				writer.append("</ul>\r\n");

			}
			writer.append("</body>\r\n")
				.append("</html>\r\n");
		}
}
