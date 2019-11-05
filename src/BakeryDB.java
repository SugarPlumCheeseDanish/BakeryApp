import java.util.ArrayList;
import java.util.Arrays;

public class BakeryDB {

    // class-level self-reference
    private static BakeryDB single_instance = null;

    // class-level actual "database" which is a list
    private ArrayList<BakeryItem> itemsList;

    // SINGLETON constructor is PRIVATE
    private BakeryDB(){
        // this only ever gets called inside of getInstance(),
        // and then, only if the private static single_instance is null!

        //*****************************
        // build our bakery database
        // ****************************

        itemsList = new ArrayList<>();

        itemsList.add(new BakeryItem("banana bread", 5.95, "03-04-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut", "dairy", "vegan")), 21));
        itemsList.add(new BakeryItem("cookie", 0.54, "05-05-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut", "dairy", "vegan")), 3));
        itemsList.add(new BakeryItem("pumpkin bread", 3.25, "09-09-2020", new ArrayList<>(), 5));
        itemsList.add(new BakeryItem("bread pudding", 4.50, "11-6-2019", new ArrayList<>(Arrays.asList("peanut", "egg")), 11));
        itemsList.add(new BakeryItem("muffin pack", 16.50, "11-11-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut", "dairy", "vegan")), 18));
        itemsList.add(new BakeryItem("eclair", 4.95, "11-07-2019", new ArrayList<>(Arrays.asList("gluten", "tree nut")), 13));
        itemsList.add(new BakeryItem("bagel", 1.95, "12-04-2019", new ArrayList<>(Arrays.asList("peanut", "egg", "tree nut", "dairy", "vegan")), 8));
        itemsList.add(new BakeryItem("red velvet cupcake", 3.95, "11-04-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut")), 11));
        itemsList.add(new BakeryItem("bread", 5.95, "03-04-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut", "dairy", "vegan")), 7));
        itemsList.add(new BakeryItem("sugar plum danish", 2.95, "11-08-2019", new ArrayList<>(Arrays.asList("peanut", "tree nut")), 40));
        itemsList.add(new BakeryItem("cookie bag", 5.95, "11-11-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut")), 4));
        itemsList.add(new BakeryItem("pizza crust", 7.00, "02-04-2020", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut", "dairy", "vegan")), 55));
        itemsList.add(new BakeryItem("blueberry scone", 3.25, "11-09-2019", new ArrayList<>(Arrays.asList("peanut", "tree nut")), 30));
        itemsList.add(new BakeryItem("honeycomb", 1.95, "12-04-2019", new ArrayList<>(Arrays.asList("gluten", "peanut", "egg", "tree nut", "dairy")), 25));
        itemsList.add(new BakeryItem("swirl cake", 25.95, "11-11-2019", new ArrayList<>(Arrays.asList("peanut", "tree nut")), 4));

    }

    public static BakeryDB getInstance(){
        if (single_instance == null) {single_instance = new BakeryDB();}
        return single_instance;
    }

    // *********************************************************
    // Database getSingleItem Method
    // returns: an ArrayList of size zero or one.
    //      if returns EMPTY LIST :: either, it was out of stock, or they typed an invalid name
    //      if returns SIZE ONE LIST :: it's returning the requested item!
    // parameter: String name which must exactly match the name of an item in our DB
    // *********************************************************
    public ArrayList<BakeryItem> getSingleItem(String name) {

        ArrayList<BakeryItem> returnItem = new ArrayList<>();

        for (BakeryItem b : itemsList) {
            if (b.getName().equalsIgnoreCase(name)) {
                if (b.getStock() == 0) {
                    System.out.println("Sorry, this item is out of stock!");
                }
                else {
                    returnItem.add(b.copySelf(1));      // return a COPY of itself!!
                    b.setStock(b.getStock() - 1);       // decrement the stock
                }
            }
        }

        return returnItem;

    }

    // *********************************************************
    // Database Search Method
    // returns: ArrayList of BakeryItems
    // parameter: String searchString, which can be
    //      all :: return ALL the contents of the DB
    //      gluten | peanut | egg | tree nut | dairy | vegan :: return only the items which have the given string in their diet (ArrayList) field
    // *********************************************************
    public ArrayList<BakeryItem> search(String searchString) {

        ArrayList<BakeryItem> matchingList = new ArrayList<>();
        String matchString = searchString.toLowerCase();

        // special case :: requesting all items
        if (searchString.equalsIgnoreCase("all")) {
            return itemsList;
        }

        // otherwise :: the string is the dietary restriction that needs to be met
        else {
            for (BakeryItem b : itemsList) {
                if (b.getDiet().contains(matchString)) {
                    matchingList.add(b);
                }
            }
        }

        return matchingList;

    }

}
