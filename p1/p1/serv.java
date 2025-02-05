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
 * Servlet implementation class serv
 */
@WebServlet("/serv")
public class serv extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public serv() {
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
    String donutId = request.getParameter("donutid");
    request.setAttribute(donutId, donutId);
    try {
      request.getRequestDispatcher("individual.jsp").forward(request, response);
    } catch (Exception e) {
      request.getRequestDispatcher("whyhere.jsp").forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request,
                        HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // TODO Auto-generated method stub
    String donutID = request.getParameter("donutID");
    String donutType = request.getParameter("donutType");
    String donutFlavor = request.getParameter("donutFlavor");
    String donutPrice = request.getParameter("donutPrice");
    String donutDesc = request.getParameter("donutDesc");
    String availableQuan = request.getParameter("availableQuantity");
    Donut selectedDonut = new Donut(Integer.parseInt(donutID), donutType,
                                    donutFlavor, donutPrice, donutDesc, Integer.parseInt(availableQuan));
    HttpSession session = request.getSession();
    selectedDonut.setQuantity(1);

    // Retrieve the cart (an ArrayList) from the session, or create a new one if
    // it doesn't exist
    ArrayList<Donut> cart = (ArrayList<Donut>)session.getAttribute("cart");
    if (cart == null) {
      cart = new ArrayList<>();
    }
    int check = -1;
    if (!cart.isEmpty()) {
      for (Donut d : cart) {
        if (d.getDonutID() == selectedDonut.getDonutID()) {
          check = cart.indexOf(d);
        }
      }
    }
    if (check == -1) {
      cart.add(selectedDonut);
    } else {
      int quantity = cart.get(check).getQuantity() + 1;
      cart.get(check).setQuantity(quantity);
    }
    session.setAttribute("cart", cart);
    request.getRequestDispatcher("individual.jsp?donutid=" + donutID)
        .forward(request, response);
  }
}
