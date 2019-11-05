import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // initialize the database
        BakeryDB myBakeryDB = BakeryDB.getInstance();

        // initialize the scanner
        Scanner keyboard = new Scanner(System.in);
        String userString;

        // initialize the shopping cart
        ArrayList<BakeryItem> shoppingCart = new ArrayList<>();     // default = list of size zero

        // welcome the user
        System.out.println("Welcome to the Brookley's Better Bakery App!");
        System.out.println("We contain peanut, gluten, soy and dairy in our products.");
        System.out.println("Would you like to peruse our products (\"p\"), or quit (\"q\")?");
        userString = keyboard.nextLine();
        System.out.println();
        boolean firstTime = true;

        while (true) {

            // they wish to quit :: break!
            if (userString.equalsIgnoreCase("q") || userString.equalsIgnoreCase("quit")) { break; }

            if (userString.equalsIgnoreCase("peruse") || userString.equalsIgnoreCase("p")) {

                // they wish to peruse the options
                System.out.println("Please enter a Restriction: gluten | peanut | egg | tree nut | dairy | vegan");
                System.out.println("To see a list of all our foods, please type \"all\". To quit type \"q\" or \"quit\".");
                userString = keyboard.nextLine();
                System.out.println();

                // user said to quit :: break!
                if (userString.equalsIgnoreCase("q") || userString.equalsIgnoreCase("quit")) { break; }

                // user entered a dietary restriction or ALL
                if (userString.equalsIgnoreCase("gluten") || userString.equalsIgnoreCase("peanut")
                        ||userString.equalsIgnoreCase("egg") ||userString.equalsIgnoreCase("tree nut")
                        ||userString.equalsIgnoreCase("dairy") ||userString.equalsIgnoreCase("vegan")
                        ||userString.equalsIgnoreCase("all")) {

                    // user entered a VALID dietary restriction or ALL
                    ArrayList<BakeryItem> matchingList = myBakeryDB.search(userString);
                    for (BakeryItem item : matchingList) {
                        System.out.println(item.getDisplayText() + "\n");
                    }

                }
                else { System.out.println("We're sorry, we could not understand the dietary restriction you entered."); }

            }
            else if (userString.equalsIgnoreCase("add") || userString.equalsIgnoreCase("a")) {

                // they wish to add to their cart
                System.out.println("Please enter the NAME of the item you wish to add:");
                userString = keyboard.nextLine();
                System.out.println();

                // get the requested item (as ArrayList)
                ArrayList<BakeryItem> returnedItemList = myBakeryDB.getSingleItem(userString);

                // no item was returned
                if (returnedItemList.size() == 0) {
                    System.out.println("We're sorry, we were unable to add " + userString + " to your cart.");
                }
                // an item was returned
                else {
                    shoppingCart.add(returnedItemList.get(0));
                    System.out.println("You added " + userString + " to your cart!!!\nHere is your shopping cart so far: ");
                    for (BakeryItem item : shoppingCart) {
                        System.out.println(item.getDisplayText() + "\n");
                    }
                }

            }
            else {
                // they did not enter a valid option
                if (firstTime) { System.out.println("Please enter a valid choice! (q: quit, p: peruse)");}
                else { System.out.println("Please enter a valid choice! (q: quit, p: peruse, a: add)");}
            }

            // we ran through the loop at least once!
            firstTime = false;
            // solicit not first time input
            System.out.println("Would you like to peruse more products (\"p\"), add an item to your cart (\"a\"), or quit (\"q\")?");
            userString = keyboard.nextLine();
            System.out.println();

        } // end while

        // shopping cart has something in it!
        if (shoppingCart.size() != 0) {
            // spit out shopping cart final info and price calculation here!
            System.out.println("Here is your shopping cart so far: ");
            for (BakeryItem item : shoppingCart) {
                System.out.println(item.getDisplayText() + "\n");
            }
            double totalCost = 0;
            for (BakeryItem item : shoppingCart) {
                totalCost += item.getPrice();
            }
            System.out.printf("The total cost of your shopping cart items is: $%.2f%n%n", totalCost);
            totalCost = totalCost * 1.07;
            System.out.printf("With tax, this comes to a TOTAL of: $%.2f%n%n", totalCost);
        }

        System.out.println("Thanks for visiting and contributing to our capitalist structure! Goodbye!");

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
