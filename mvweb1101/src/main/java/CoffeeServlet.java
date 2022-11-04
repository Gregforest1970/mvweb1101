

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class SupplierServlet
 */
@WebServlet("/coffee")
public class CoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&characterEncoding=utf8","root","1234");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Coffees</title>");
            out.println("</head>");
            out.println("<body>");
            viewTable(conn,out);
            out.println("</body>");
            out.println("</html>");         
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            out.close();
        }

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 public  void viewTable(Connection con,PrintWriter out) throws SQLException {
	        Statement stmt = null;
	        String query =
	                "select * from classicmodels.COFFEES";
	        try {
	            stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            out.println("<table border='1' width='50%'>");
	            while (rs.next()) {             
	                out.println("<tr><td>");
	                int supplierID = rs.getInt("SUP_ID");
	                out.println(""+supplierID);
	                out.println("</td><td>");
	                String cofName = rs.getString("COF_NAME");
	                out.println(""+cofName);
	                out.println("</td><td>");
	                String price = rs.getString("Price");
	                out.println(""+price);
	                out.println("</td><td>");
	                String sale = rs.getString("Sales");
	                 out.println(""+sale);
	                out.println("</td><td>");
	                String total = rs.getString("Total");
	                out.println(""+total);	                
	                out.println("</td></tr>");
	            }
	            out.println("</table>");
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            if (stmt != null) {
	                stmt.close();
	            }
	        }
	    }

}
