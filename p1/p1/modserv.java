package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class modserv
 */
@WebServlet("/modserv")
public class modserv extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public modserv() {
    super();
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

    String action = request.getParameter("modAction");
    int id = Integer.parseInt(request.getParameter("donutID"));
    try {
      Connection conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/donutdb", "root", /*password here*/);
      if (action.equals("inc")) {
        String getMenuItem =
            "SELECT AvailableQuantity FROM doughnut_menu WHERE ProductKey = ?";
        PreparedStatement getMenuItemStmt = conn.prepareStatement(getMenuItem);
        getMenuItemStmt.setInt(1, id);
        ResultSet rs = getMenuItemStmt.executeQuery();
        if (rs.next()) {
          String colVal = rs.getString(1);
          int aq = Integer.parseInt(colVal);
          aq += 1;
          String updateMenuItem = "UPDATE doughnut_menu SET " +
                                  "AvailableQuantity = ? WHERE ProductKey = ?";
          PreparedStatement updateMenuStmt =
              conn.prepareStatement(updateMenuItem);
          updateMenuStmt.setInt(1, aq);
          updateMenuStmt.setInt(2, id);
          int err = updateMenuStmt.executeUpdate();
        }
      } else {
        String getMenuItem =
            "SELECT AvailableQuantity FROM doughnut_menu WHERE ProductKey = ?";
        PreparedStatement getMenuItemStmt = conn.prepareStatement(getMenuItem);
        getMenuItemStmt.setInt(1, id);
        ResultSet rs = getMenuItemStmt.executeQuery();
        if (rs.next()) {
          String colVal = rs.getString(1);
          int aq = Integer.parseInt(colVal);
          System.out.println(aq);
          aq -= 1;
          String updateMenuItem = "UPDATE doughnut_menu SET " +
                                  "AvailableQuantity = ? WHERE ProductKey = ?";
          PreparedStatement updateMenuStmt =
              conn.prepareStatement(updateMenuItem);
          updateMenuStmt.setInt(1, aq);
          updateMenuStmt.setInt(2, id);
          int err = updateMenuStmt.executeUpdate();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    doGet(request, response);
  }
}
