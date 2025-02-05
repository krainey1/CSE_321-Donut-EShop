package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Servlet implementation class cserv
 */
@WebServlet("/cserv")
public class cserv extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public cserv() {
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
    request.getRequestDispatcher("cart.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *     response)
   */
  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // here use this post request to enter transactions

    // retrieve session in order to get cart vars
    HttpSession session = request.getSession();
    ArrayList<Donut> cart = (ArrayList<Donut>)session.getAttribute("cart");
    String name = request.getParameter("name");
    String card = request.getParameter("card");
    String status = "OPEN";
    float total = 0;
    for (Donut d : cart) {
      total += Double.parseDouble(d.getPrice()) * d.getQuantity();
    }

    try (Connection conn = DriverManager.getConnection(
             "jdbc:mysql://localhost:3306/donutdb", "root", "colej123");) {
      String sql =
          "INSERT INTO doughnut_orders (Name, CardNumber, Total, "
          + "Timestamp, Status, TransactionLog) VALUES (?, ?, ?, ?, ?, ?);";

      try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        stmt.setString(1, name);
        stmt.setString(2, card);
        stmt.setFloat(3, total);
        stmt.setDate(4, date);
        stmt.setString(5, status);
        int itrs = 0;
        int last = cart.size() - 1;
        // create a new running log of all transactions
        String log = "";
        for (Donut d : cart) {
          int ammount = d.getQuantity();
          double donutPrice =
              d.getQuantity() * Double.parseDouble(d.getPrice());
          String cakeType = d.getType();
          String flavorType = d.getFlavor();
          String transactionEntry = String.format(
              "%d Donut(s) of type %s with a flavor of %s for %.2f", ammount,
              cakeType, flavorType, donutPrice);
          if (itrs != last) {
            transactionEntry = transactionEntry.concat(
                ","); // concat comma if this isn't the last cart entry
          }
          // concat each transaction entry into a log of transactions
          log += transactionEntry;
          itrs++;
        }
        stmt.setString(6, log);
        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
          for (Donut d : cart) {
            String getMenuItem = "SELECT AvailableQuantity FROM " +
                                 "doughnut_menu WHERE ProductKey = ?";
            PreparedStatement getMenuItemStmt =
                conn.prepareStatement(getMenuItem);
            getMenuItemStmt.setInt(1, d.getDonutID());
            if (getMenuItemStmt.executeQuery() != null) {
              ResultSet rs = getMenuItemStmt.executeQuery();
              ResultSetMetaData rsmd = rs.getMetaData();
              int columnsNumber = rsmd.getColumnCount();

              if (rs.next()) {
                String colVal = rs.getString(1);
                int aq = Integer.parseInt(colVal);
                System.out.println(aq);
                aq -= d.getQuantity();
                String updateMenuItem =
                    "UPDATE doughnut_menu SET AvailableQuantity = ? WHERE " +
                    "ProductKey = ?";
                PreparedStatement updateMenuStmt =
                    conn.prepareStatement(updateMenuItem);
                updateMenuStmt.setInt(1, aq);
                updateMenuStmt.setInt(2, d.getDonutID());
                int err = updateMenuStmt.executeUpdate();
              }

            } else {
              System.err.println("Could not execute!");
            }
          }

          request.getRequestDispatcher("order.jsp").forward(request, response);
        } else {
          response.getWriter().write("Inserted values into the table");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      response.getWriter().write("Error updating menu!");
    }
  }
}
