package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BuildMenu {

  ArrayList<Donut> menu;

  public BuildMenu() {
    DonutMenu shell = new DonutMenu();
    menu = shell.getList();
    Connection mycon = null;
    Statement sql_stmt = null;
    ResultSet records = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/donutdb",
                                          "root", /*password here*/);
      sql_stmt = mycon.createStatement();
      records = sql_stmt.executeQuery("SELECT * FROM doughnut_menu");
      while (records.next()) {
        String ids = records.getString("ProductKey");
        Integer id = Integer.parseInt(ids);
        int quantityAvailable = Integer.parseInt(records.getString("AvailableQuantity"));
        Donut newElement = new Donut(
            id, records.getString("Doughnut"), records.getString("Type"),
            records.getString("Price"), records.getString("pageinfo"), quantityAvailable);
        menu.add(newElement);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Donut getDbyId(Integer donutID) {
    Donut d = menu.get(donutID - 1);
    return d;
  }

  public ArrayList<Donut> getMenu() { return menu; }

  public void setMenu(ArrayList<Donut> menu) { this.menu = menu; }
}
