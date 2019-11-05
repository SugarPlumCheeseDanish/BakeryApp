import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> diet = new ArrayList<>(Arrays.asList("gluten", "peanut",
                "egg", "tree nut", "dairy", "vegan"));
        BakeryItem test = new BakeryItem("muffin", 3.04, "03-04-2019", diet, 21);

        System.out.println(test.getDisplayText());

    }

}
