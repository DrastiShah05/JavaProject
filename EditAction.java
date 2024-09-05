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
 * Servlet implementation class EditAction
 */
@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAction() {
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
		String c_id= request.getParameter("c_id");
		String c_name= request.getParameter("c_name");
		String c_model = request.getParameter("c_model");
		String c_color = request.getParameter("c_color");
        String c_price = request.getParameter("c_price");
        String linkUrl="DisplayCar";
    	try
		{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		String updateSQL = "UPDATE book SET bname=?,bprice=? WHERE id=?";
    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
    		PreparedStatement pst=  con.prepareStatement(updateSQL);
    		pst.setString(1, c_id);
    		pst.setString(2,c_name);
    		pst.setString(3, c_model);
    		pst.setString(4,c_color);
    		pst.setString(5,c_price);
    		pst.executeUpdate();
    		out.println("Car Updated!");
    		out.println("<a href ='" + linkUrl + "'>" +"Show Cars" +"</a>");
    		System.out.print("Car Updated Successfully");
    		
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
	
	}

}
