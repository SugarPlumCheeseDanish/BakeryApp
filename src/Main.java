import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// testing code
//        ArrayList<String> dietAll = new ArrayList<>(Arrays.asList("gluten", "peanut",
//                "egg", "tree nut", "dairy", "vegan"));
//
//        BakeryItem test = new BakeryItem("muffin",
//                3.04,
//                "03-04-2019",
//                dietAll,
//                21);
//
//        System.out.println(test.getDisplayText());
//
//        ArrayList<String> dietNone = new ArrayList<>();
//        System.out.println(Arrays.toString(dietNone.toArray()));
//        System.out.println("size is " + dietNone.size());
//
//
//        BakeryItem another = new BakeryItem("bread pudding", 4.50, "11-6-2019",
//                new ArrayList<>(Arrays.asList("peanut", "egg")), 11);
//        System.out.println(another.getDisplayText());
//
//        BakeryDB myBakeryDB = BakeryDB.getInstance();
//        ArrayList<BakeryItem> myList = myBakeryDB.getItemsList();
//        for (BakeryItem item : myList) {
//            System.out.println(item.getDisplayText() + "\n");
//        }

        // initialize the database
        BakeryDB myBakeryDB = BakeryDB.getInstance();


        // initialize the scanner
        Scanner keyboard = new Scanner(System.in);
        String userString;

        // welcome the user
        System.out.println("Welcome to the Brookley's Better Bakery App!");
        System.out.println("We contain peanut, gluten, soy and dairy in our products.");
        System.out.println("Would you like to peruse our products (\"p\"), or quit (\"q\")?");
        userString = keyboard.nextLine();
        boolean firstTime = true;

        while(true) {

            // they wish to quit :: break immediately!
            if (userString.equalsIgnoreCase("q") || userString.equalsIgnoreCase("quit")) { break; }

            // they wish to peruse!
            if (userString.equalsIgnoreCase("peruse") || userString.equalsIgnoreCase("p")) {
                // perusing
                System.out.println("You wish to Peruse!");
                System.out.println("Please enter a Restriction: gluten | peanut | egg | tree nut | dairy | vegan");
                System.out.println("To see a list of all our foods, please type \"all\". To quit type \"q\" or \"quit\".");
                userString = keyboard.nextLine();
                ArrayList<BakeryItem> matchingList = myBakeryDB.search(userString);
                for (BakeryItem item : matchingList) {
                    System.out.println(item.getDisplayText() + "\n");
                }
            }

            // they wish to add to the cart
            else if (userString.equalsIgnoreCase("add") || userString.equalsIgnoreCase("a")) {

            }

            // they did not enter a valid option
            else {
                if (firstTime) {
                    System.out.println("Please enter a valid choice! (q: quit, p: peruse)");
                } else {
                    System.out.println("Please enter a valid choice! (q: quit, p: peruse, a: add)");
                }
            }

            // we ran through the loop at least once!
            firstTime = false;

            // solicit not first time input
            System.out.println("Would you like to peruse more products (\"p\"), add an item to your cart (\"a\"), or quit (\"q\")?");
            userString = keyboard.nextLine();

        } // end while

        // spit out shopping cart final info and price calculation here!

    } // end main

} // end class


//// TESTING CODE :: USE INSIDE OF MAIN() IF NEEDED
//
//// show egg list real quick
//        System.out.println("\n\nCHECKING DATABASE!");
//                ArrayList<BakeryItem> matchingList = myBakeryDB.search("egg");
//        for (BakeryItem item : matchingList) {
//        System.out.println(item.getDisplayText() + "\n");
//        }
//
//        // pull one honeycomb out
//        System.out.println("\n\npull a local copy***********");
//        ArrayList<BakeryItem> testOne = new ArrayList<>(myBakeryDB.getSingleItem("honeycomb"));
//        for (BakeryItem item : testOne) {
//        System.out.println(item.getDisplayText());
//        }
//
//        // show egg list real quick
//        System.out.println("\n\nCHECKING DATABASE!");
//        matchingList = myBakeryDB.search("egg");
//        for (BakeryItem item : matchingList) {
//        System.out.println(item.getDisplayText() + "\n");
//        }
//
//        // modify our LOCAL honeycomb
//        System.out.println("\n\nMODIFY local copy***********");
//        BakeryItem myItem = testOne.get(0);
//        myItem.setStock(3);
//        System.out.println(myItem.getDisplayText());
//
//        // show egg list real quick
//        System.out.println("\n\nCHECKING DATABASE!");
//        matchingList = myBakeryDB.search("egg");
//        for (BakeryItem item : matchingList) {
//        System.out.println(item.getDisplayText() + "\n");
//        }
//
//        // pull another honeycomb out
//        ArrayList<BakeryItem> testTwo = new ArrayList<>(myBakeryDB.getSingleItem("honeycomb"));
//        for (BakeryItem item : testTwo) {
//        System.out.println(item.getDisplayText());
//        }
//
//        // show egg list real quick
//        System.out.println("\n\nCHECKING DATABASE!");
//        matchingList = myBakeryDB.search("egg");
//        for (BakeryItem item : matchingList) {
//        System.out.println(item.getDisplayText() + "\n");
//        }
