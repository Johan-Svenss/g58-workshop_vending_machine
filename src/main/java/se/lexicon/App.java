package se.lexicon;

import se.lexicon.model.VendingMachine;
import se.lexicon.model.product.Burger;
import se.lexicon.model.product.Pizza;
import se.lexicon.model.product.Product;
import se.lexicon.model.product.Tacos;
import java.util.Arrays;


/**
 * Entry point for the vending machine application
 * Showing:
 */
public class App 
{
    public static void main( String[] args )
    {

        // Step 1: Create a vending maschine and fill it with goods
        // Each product needs to have a unique Id
        VendingMachine vendingMachine = new VendingMachine(Arrays.asList(
                new Pizza(1,200, "OxFilet Pizza", true),
                new Burger(2, 100, "Cheeseburger", true),
                new Burger(3,150, "Baconburger", false),
                new Tacos(4, 200, "Mild Taco", false)
                )
        );

        // Step 2: Simulate the user inserting money into the machine
        // Only valid denominations are accepted (e.g., 1, 5, 10, 20, etc.)
        vendingMachine.addCurrency(100); // Insert 100 SEK

        // Step 3: Print the current balance to confirm the deposit
        System.out.println("Balance: " + vendingMachine.getBalance());

        // Step 4: Show the description of the product with ID 1
        // This helps the user decide whether they want to buy it
        System.out.println(vendingMachine.getDescription(1));

        // Step 5: Attempt to purchase the product with ID 1
        // If the user has enough money, the product is returned
        Product p = vendingMachine.request(1);

        // Step 6: Simulate using the product (e.g., eating or chewing)
        // The use() method gives a fun message based on the product type
        if (p != null) {
            System.out.println(p.use());
        }

        // Step 7: End the session and return any leftover balance as change
        System.out.println("Change: " + vendingMachine.endSession());


    }
}
