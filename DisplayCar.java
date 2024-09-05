package car;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayCar
 */
@WebServlet("/DisplayCar")
public class DisplayCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out= response.getWriter();
    	try
		{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/root","root","password");
    		PreparedStatement pst=  con.prepareStatement("Select * from car");
    		ResultSet rs=  pst.executeQuery();
    		while(rs.next())
    		{
    			String c_id=rs.getString(1);
    			String c_name=rs.getString(2);
    			String c_model=rs.getString(3);
    			String c_color=rs.getString(4);
    			String c_price=rs.getString(5);
    			String linkUrl = "Details?c_name=" + c_name + "&c_model=" + c_model + "&c_color=" + c_color + "&c_price=" + c_price + "&c_id=" + c_id;
    			out.println("<html>");
    			out.println("<body>");
    			out.println("<a href='" + linkUrl + "'>" + c_name + "</a>");
    			out.println("</body>");
    			out.println("</html>");
    		}
    		out.close();
		}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
