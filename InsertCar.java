package car;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertCar
 */
@WebServlet("/InsertCar")
public class InsertCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String c_name= request.getParameter("c_name"); 
		String c_model= request.getParameter("c_model");
		String c_color= request.getParameter("c_color");
		String c_price= request.getParameter("c_price");
		String linkUrl="DisplayCar";
    	try
		{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/root","root","password");
    		PreparedStatement pst=  con.prepareStatement("INSERT INTO car (c_name,c_model,c_color,c_price) VALUES (?,?,?,?)");
    		pst.setString(1,c_name);
    		pst.setString(2,c_model);
    		pst.setString(3,c_color);
    		pst.setString(4,c_price);
    		pst.executeUpdate();
    		out.println("Car Added into the database");
    		out.println("<a href ='" + linkUrl + "'>" +"Show Cars" +"</a>");
    		System.out.print("Car Added");
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
		
	}

}
