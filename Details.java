package car;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarDetails
 */
@WebServlet("/CarDetails")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String c_id = request.getParameter("c_id");
		String c_name = request.getParameter("c_name");
		String c_model = request.getParameter("c_model");
		String c_color = request.getParameter("c_color");
        String c_price = request.getParameter("c_price");
        
        
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Car Name: " + c_name + "</h1>");
        out.println("<h1>Car Model: " + c_model + "</h1>");
        out.println("<h1>Car Color: " + c_color + "</h1>");
        out.println("<h1>Car Price: " + c_price + "</h1>");
        
        String delUrl="Delete?c_id="+c_id;
        out.println("<a href='" + delUrl + "'>" + "Delete" + "</a>");
        
        String editUrl="EditCar?c_id="+c_id+"&c_name="+c_name+"&c_model="+c_model+"&c_color="+c_color+"&c_price="+c_price;
        out.println("<a href='" + editUrl + "'>" + "Edit" + "</a>");
        
        String linkUrl="login.jsp";                
        out.println("<a href='" + linkUrl + "'>" + "Home" + "</a>");
       
        out.println("</body>");
        out.println("</html>");
        
        out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
