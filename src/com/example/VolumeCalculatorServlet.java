

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.Calculation;

public class VolumeCalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {
				
		String stringwidth = getServletContext().getInitParameter("width");
		String stringheight = getServletContext().getInitParameter("height");
		String stringdepth = getServletContext().getInitParameter("depth");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
				
		int scaleC = 0;
		
		Calculation cal = new Calculation();	
		
		int width = Integer.parseInt(stringwidth);
		int height = Integer.parseInt(stringheight);
		int depth = Integer.parseInt(stringdepth);
			
		String stringScale = req.getParameter("scale");	
		// Not allow empty value for the parameters	
		if (stringScale == null || stringScale.isEmpty()) {
			
			resp.sendRedirect("index.jsp");
		}		
		
		else if (stringScale.contains("/")) {
			
			String[] str = stringScale.split("/",2);
			double a = Double.parseDouble(str[0]);			
			double b = Double.parseDouble(str[1]);		
			
				if (a == 0 || b == 0) {
				resp.sendRedirect("index.jsp");
				}
			
				else {					
					double scaleDouble = (a/b) * cal.calcVolume(width, height, depth);
					scaleC = (int)scaleDouble;			
				}
			}
		
		else if (stringScale.contains(".")) {
			
			double scaleDouble = Double.parseDouble(stringScale) 
					* cal.calcVolume(width, height, depth);
			scaleC = (int)scaleDouble;
		}
		
		else if (Double.parseDouble(stringScale) % 3 == 0){			
			
			resp.sendRedirect("index.jsp");
					
			}
		
		else {
					scaleC = (int) Double.parseDouble(stringScale) 
								* cal.calcVolume(width, height, depth);
					
				}
					
				
				HttpSession session = req.getSession();
				session.setAttribute("cal", cal);
				session.setMaxInactiveInterval(30 * 60);	

				out.println("<html><head>");
				out.println("<head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"></head><body>");
				
				
				out.println("<h2>Scaling Factor Result</h2><br>");
				out.println(" <b> Width : " + width + "m</b><br>");
				out.println(" <b> Height : " + height + "m</b><br>");
				out.println(" <b> Depth : " + depth + "m</b><br><br>");
				try {
				out.println("<b>The volume is " + 
							cal.calcVolume(width, height, depth) + 
							"m</b><br>");
				out.println("<b>The Scaling factor is " +
							scaleC + "m</b><br><br>");
				} catch (Exception e) {
					e.printStackTrace();
				}
				out.println("<b>Link @Fast Sheridan</b><br>" + 
							"<a href=\"http://fast.sheridancollege.ca\">click here!</a><br>");	
				
				out.println("</body></html>");
				out.close();

		}
						
		
	}
	



