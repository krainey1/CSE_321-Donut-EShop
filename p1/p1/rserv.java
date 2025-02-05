package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class rserv
 */
@WebServlet("/rserv")
public class rserv extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public rserv() {
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
    String donutID = request.getParameter("donutID");
    HttpSession session = request.getSession();
    ArrayList<Donut> cart = (ArrayList<Donut>)session.getAttribute("cart");
    int key = -1;
    for (Donut d : cart) {
      if (d.getDonutID() == Integer.parseInt(donutID)) {
        key = cart.indexOf(d);
      }
    }
    if (key != -1) {
      if (cart.get(key).getQuantity() == 1) {
        cart.remove(key);
      } else {
        int quant = cart.get(key).getQuantity();
        cart.get(key).setQuantity(quant - 1);
      }
    }
    doGet(request, response);
  }
}
