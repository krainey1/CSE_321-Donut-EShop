package p1;

import java.io.IOException; 
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class mserv
 */
@WebServlet("/mserv")
public class mserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Retrieve the cart (an ArrayList) from the session, or create a new one if it doesn't exist
	    HttpSession session = request.getSession();
        ArrayList<Donut> cart = (ArrayList<Donut>) session.getAttribute("cart");
        if(cart == null) {
        	cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        
		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String donutID = request.getParameter("donutID");
        String donutType = request.getParameter("donutType");
        String donutFlavor = request.getParameter("donutFlavor");
        String donutPrice = request.getParameter("donutPrice");
        String donutDesc = request.getParameter("donutDesc");
        String quantityAvailable = request.getParameter("availableQuantity");
        
        Donut selectedDonut = new Donut(Integer.parseInt(donutID), donutType, donutFlavor, 
        		donutPrice, donutDesc, Integer.parseInt(quantityAvailable));
        // try to obtain the session information
        HttpSession session = request.getSession();
        selectedDonut.setQuantity(1);

        // Retrieve the cart (an ArrayList) from the session, or create a new one if it doesn't exist
        ArrayList<Donut> cart = (ArrayList<Donut>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        int check = -1;
       if(!cart.isEmpty()) {
          for (Donut d : cart) {
        	if(d.getDonutID() == selectedDonut.getDonutID()) {
        		check = cart.indexOf(d);
        	}	
          } 
        }
        if(check == -1) {
        	cart.add(selectedDonut);
        }
        else {
        	boolean overflow = selectedDonut.getAvailableQuantity()  <  cart.get(check).getQuantity() + 1;
        	if(!overflow) {
        		int quantity = cart.get(check).getQuantity() + 1;
            	cart.get(check).setQuantity(quantity);
        	}
        } 
        session.setAttribute("cart", cart);
        
		doGet(request, response);
	}
	
}

