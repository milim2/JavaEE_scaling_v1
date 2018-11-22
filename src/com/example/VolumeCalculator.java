

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.Calculation;

public class VolumeCalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final int WIDTH = 10;
	private final int HEIGHT = 10;
	private final int DEPTH = 18;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
				
		int scaleC = 0;
		
		Calculation cal = new Calculation();	
		
		// Not allow empty value for the parameters		
		String strscale = req.getParameter("scale");	
		
		if (strscale == null || strscale.isEmpty()) {
			
			resp.sendRedirect("index.jsp");
		}		
		
		else if (strscale.contains("/")) {
			
			String[] str = strscale.split("/",2);
			double a = Double.parseDouble(str[0]);			
			double b = Double.parseDouble(str[1]);		
			
				if (a == 0 || b == 0) {
				resp.sendRedirect("index.jsp");
				}
			
				else {					
					double scaleD = (a/b) * (cal).calcVolume(WIDTH, HEIGHT, DEPTH);
					scaleC = (int)(scaleD);			
				}
			}
		
		else if (strscale.contains(".")) {
			
			double scaleD = Double.parseDouble(strscale) 
					* (cal).calcVolume(WIDTH, HEIGHT, DEPTH);
			scaleC = (int)(scaleD);
		}
		
		else if (Double.parseDouble(strscale) % 3 == 0){			
			
			resp.sendRedirect("index.jsp");
					
			}
		
		else {
					scaleC = (int) Double.parseDouble(strscale) 
								* (cal).calcVolume(WIDTH, HEIGHT, DEPTH);
					
				}
					
				
				HttpSession session = req.getSession();
				session.setAttribute("cal", cal);
				session.setMaxInactiveInterval(30 * 60);	

				out.println("<h2>Scaling Factor Result</h2><br>");
				out.println(" <b> Width : " + WIDTH + "m</b><br>");
				out.println(" <b> Height : " + HEIGHT + "m</b><br>");
				out.println(" <b> Depth : " + DEPTH + "m</b><br><br>");
				try {
				out.println("<b>The volume is : " + 
							(cal).calcVolume(WIDTH, HEIGHT, DEPTH) + 
							"m</b><br>");
				out.println("<b>The Scaling factor is : " +
							scaleC + "m</b><br><br>");
				} catch (Exception e) {
					e.printStackTrace();
				}
				out.println("<b>Link @Fast Sheridan</b><br>" + 
							"<a href=\"http://fast.sheridancollege.ca\">click here!</a><br>");	
				
				out.close();

		}
						
		
	}
	



