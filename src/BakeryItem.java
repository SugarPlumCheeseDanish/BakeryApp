import java.util.ArrayList;
import java.util.Arrays;

public class BakeryItem {
    private String name;
    private double price;
    private String expiration;
    private ArrayList<String> diet = new ArrayList<>();
    private int stock;

    public BakeryItem() {
    }

    public BakeryItem(String name, double price, String expiration, ArrayList<String> diet, int stock) {
        this.name = name;
        this.price = price;
        this.expiration = expiration;
        this.diet = diet;
        this.stock = stock;
    }

    //*****************************
    // dietary restriction methods
    //*****************************


    //*************************
    // DISPLAY method
    //*************************
    public String getDisplayText(){

        String dietString = Arrays.toString(diet.toArray()); // convert via built-ins to nice String
        String dietFinal = dietString.substring(1, dietString.length()-1); // remove brackets

        return String.format("|| Name: %s%n|| Price: %.2f%n|| Expiration: %s%n"+
                        "|| Dietary Restriction Met: %s%n|| Quantity in Stock: %d",
                        name, price, expiration, dietFinal,stock);

    }

    //*************************
    // auto generated getters + setters
    //*************************
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public ArrayList<String> getDiet() {
        return diet;
    }

    public void setDiet(ArrayList<String> diet) {
        this.diet = diet;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
