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

        // initialize as true: we are "shopping"
        boolean shopping = true;

        // welcome the user
        System.out.println("Welcome to the Brookley's Better Bakery App!");
        System.out.println("We contain peanut, gluten, soy and dairy in our products.");
        System.out.println("\nTo search for foods that you *can* eat, please enter the name of your dietary restriction:");
        System.out.println("Restrictions: gluten | peanut | egg | tree nut | dairy | vegan");
        System.out.println("To see a list of all our foods, please type \"all\".");

        while(shopping) {

            String userString = keyboard.nextLine();

            // give user the option to quit!
            if (userString.equalsIgnoreCase("q") || userString.equalsIgnoreCase("quit")) {
                break;
            }

            ArrayList<BakeryItem> matchingList = myBakeryDB.search(userString);
            for (BakeryItem item : matchingList) {
                System.out.println(item.getDisplayText() + "\n");
            }

            System.out.println("Would you like to search for another food that you *can* eat? (y/n)");
            userString = keyboard.nextLine();
            if (userString.equalsIgnoreCase("n")) {
                break;
            }
            else {
                System.out.println("Enter a Restriction: gluten | peanut | egg | tree nut | dairy | vegan");
                System.out.println("To see a list of all our foods, please type \"all\".");
            }

        } // end while

    }

}
