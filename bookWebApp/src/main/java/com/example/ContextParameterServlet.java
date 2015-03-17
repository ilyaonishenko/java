package com.example;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
public class ContextParameterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
			ServletContext c = this.getServletContext();
			PrintWriter writer = response.getWriter();
			writer.append("settingOne: ").append(c.getInitParameter("settingOne"))
				.append("settingTwo: ").append(c.getInitParameter("settingTwo"));
		}
}
