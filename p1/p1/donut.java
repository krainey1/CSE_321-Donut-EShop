package p1;

import java.util.ArrayList;

public class Donut {

  private Integer donutID;
  private Integer quantity;
  private String type;
  private String flavor;
  private String price;
  private String description;
  private int quantityAvailable;

  public Donut() {}

  public Donut(Integer donutID, String type, String flavor, String price,
               String description, int quantityAvailable) {
    this.donutID = donutID;
    this.type = type;
    this.price = price;
    this.flavor = flavor;
    this.description = description;
    this.quantityAvailable = quantityAvailable;
  }

  public Integer getDonutID() { return donutID; }

  public void setDonutID(Integer donutID) { this.donutID = donutID; }

  public String getType() { return type; }

  public void setType(String type) { this.type = type; }

  public String getFlavor() { return flavor; }

  public void setFlavor(String flavor) { this.flavor = flavor; }

  public String getPrice() { return price; }

  public void setPrice(String price) { this.price = price; }

  public String getDescription() { return description; }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public Integer getQuantity() { return quantity; }

  public void setQuantity(Integer quantity) { this.quantity = quantity; }
 
  public int getAvailableQuantity() { return this.quantityAvailable; }

  public static int getTotal(ArrayList<Donut> cart) {
    int total = 0;
    for (Donut d : cart) {
      total += d.getQuantity();
    }
    return total;
  }
  
}
