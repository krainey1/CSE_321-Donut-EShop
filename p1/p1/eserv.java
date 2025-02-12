package p1;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.HttpMethodConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Servlet implementation class eserv
 */
@WebServlet("/eserv")
@ServletSecurity(
    value = @HttpConstraint(rolesAllowed = {"employee","admin"}),
    httpMethodConstraints =
    {
      @HttpMethodConstraint(value = "GET", rolesAllowed = {"employee","admin"})
      , @HttpMethodConstraint(value = "POST", rolesAllowed = {"employee","admin"})
    })
public class eserv extends HttpServlet {
  private static final long serialVersionUID = 1L;
  Connection conn;

  /**
   * @throws ClassNotFoundException 
 * @see HttpServlet#HttpServlet()
   */
  public eserv() throws ClassNotFoundException {
    super();

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/donutdb",
                                            "root", /*password here*/);
    } catch(SQLException ex) {
    	ex.printStackTrace();
    }
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *     response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    request.getRequestDispatcher("employee.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *     response)
   */
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
	  // get all the sent params
	  int OrderID = Integer.parseInt(request.getParameter("OrderID"));
	   try (Connection conn = DriverManager.getConnection(
	             "jdbc:mysql://localhost:3306/donutdb", "root", /*password here*/);) {
	      String sql = "UPDATE doughnut_orders SET Status='CLOSED' WHERE OrderID = ?";

	      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	    	stmt.setInt(1, OrderID);
	        stmt.executeUpdate();
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      response.getWriter().write("Error updating orders!.");
	    }
	   	request.getRequestDispatcher("employee.jsp").forward(request,response);
  }
}
