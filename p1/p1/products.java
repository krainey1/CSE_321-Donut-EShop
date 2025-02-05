package p1;

import java.io.IOException; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class products
 */
@WebServlet("/products")
public class products extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public products() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
	 request.getRequestDispatcher("admin.jsp").forward(request, response);
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
String admin_action = (String) request.getParameter("admin_action"); // admin_action should contain new_donut if new, have admin_action across all forms just change the value
Connection mycon=null;

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/donutdb","root","colej123"); //your password
        if (admin_action.equals("new_donut")) {
        Integer donutID = Integer.parseInt(request.getParameter("donutID"));
        Float donutPrice = Float.parseFloat(request.getParameter("donutPrice"));
	    String donutType = request.getParameter("donutType");
	    String donutFlavor = request.getParameter("donutFlavor");
	    String donutDesc = request.getParameter("donutDesc");
	    String sql = "INSERT INTO doughnut_menu (ProductKey, Doughnut, Type, Price, pageinfo, AvailableQuantity) " +
	                        "VALUES (?, ?, ?, ?, ?, ?);";

          try (PreparedStatement stmt = mycon.prepareStatement(sql)) {
          stmt.setInt(1, donutID);
              stmt.setString(2, donutType);
              stmt.setString(3, donutFlavor);
              stmt.setFloat(4, donutPrice);
              stmt.setString(5, donutDesc);
              stmt.setInt(6, 20);
              stmt.executeUpdate();
          
          } catch (Exception e) {
          e.printStackTrace();
          }
        } 
        else if (admin_action.equals("delete_donut")) {
        Integer donutID = Integer.parseInt(request.getParameter("donutID"));
        String sql = "DELETE FROM doughnut_menu WHERE ProductKey = ?;";
        
        try (PreparedStatement stmt = mycon.prepareStatement(sql)) {
          stmt.setInt(1, donutID);
          stmt.executeUpdate();
          
          } catch (Exception e) {
          e.printStackTrace();
          }
        }
        else if(admin_action.equals("edit_donut")) {
        	Integer donutID = Integer.parseInt(request.getParameter("donutID"));
        	Integer editParam = Integer.parseInt(request.getParameter("to_edit"));
        	String updateInfo = request.getParameter("updateInfo");
        	
        	if(editParam == 1)
    		{
    		  		String updateMenuItem = "UPDATE doughnut_menu SET Doughnut = ? WHERE ProductKey = ?";
    		      	PreparedStatement updateMenuStmt = mycon.prepareStatement(updateMenuItem);
    		      	updateMenuStmt.setString(1, updateInfo);
    		      	updateMenuStmt.setInt(2, donutID);
    		      	int err = updateMenuStmt.executeUpdate();
    		}
        	else if(editParam == 2)
        	{
        		String updateMenuItem = "UPDATE doughnut_menu SET Type = ? WHERE ProductKey = ?";
		      	PreparedStatement updateMenuStmt = mycon.prepareStatement(updateMenuItem);
		      	updateMenuStmt.setString(1, updateInfo);
		      	updateMenuStmt.setInt(2, donutID);
		      	int err = updateMenuStmt.executeUpdate();
        	}
        	else if(editParam == 3)
        	{
        		String updateMenuItem = "UPDATE doughnut_menu SET Price = ? WHERE ProductKey = ?";
		      	PreparedStatement updateMenuStmt = mycon.prepareStatement(updateMenuItem);
		      	Float update = Float.parseFloat(updateInfo);
		      	updateMenuStmt.setFloat(1, update);
		      	updateMenuStmt.setInt(2, donutID);
		      	int err = updateMenuStmt.executeUpdate();
        	}
        	else if(editParam == 4)
        	{
        		String updateMenuItem = "UPDATE doughnut_menu SET pageinfo = ? WHERE ProductKey = ?";
		      	PreparedStatement updateMenuStmt = mycon.prepareStatement(updateMenuItem);
		      	updateMenuStmt.setString(1, updateInfo);
		      	updateMenuStmt.setInt(2, donutID);
		      	int err = updateMenuStmt.executeUpdate();
        	}
        	else if(editParam == 5)
        	{
        		String updateMenuItem = "UPDATE doughnut_menu SET AvailableQuantity = ? WHERE ProductKey = ?";
		      	PreparedStatement updateMenuStmt = mycon.prepareStatement(updateMenuItem);
		      	Integer update = Integer.parseInt(updateInfo);
		      	updateMenuStmt.setInt(1, update);
		      	updateMenuStmt.setInt(2, donutID);
		      	int err = updateMenuStmt.executeUpdate();
        	}
        }
        } catch(Exception e) {e.printStackTrace(); }
        doGet(request, response);
}

}