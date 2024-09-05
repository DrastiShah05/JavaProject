package car;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCar
 */
@WebServlet("/EditCar")
public class EditCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCar() {
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
		PrintWriter out= response.getWriter();
		out.println("Edit Car");
		String c_id = request.getParameter("c_id");
		String c_name = request.getParameter("c_name");
		String c_model = request.getParameter("c_model");
		String c_color = request.getParameter("c_color");
        String c_price = request.getParameter("c_price");
        out.println("<form action='EditAction' method='POST'>");
        out.print("<table>");  
        out.print("<input type='hidden' name='c_id' value='"+c_id+"'/>");  
        out.print("Car Name:<input type='text' name='c_name' value='"+c_name+"'/>"); 
        out.print("Car Model:<input type='text' name='c_model' value='"+c_model+"'/>");
        out.print("Car Color:<input type='text' name='c_color' value='"+c_color+"'/>");
        out.print("Car Price:<input type='text' name='c_price' value='"+c_price+"'/>"); 
        out.println("<input type='submit'value='EditBook'>");
        out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
