package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.model.product.Burger;
import se.lexicon.model.product.Pizza;
import se.lexicon.model.product.Product;
import se.lexicon.model.product.Tacos;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {

    private IVendingMachine vm;

    /**
     * This method runs before each test.
     * It sets up a fresh vending machine with candy products.
     */
    @BeforeEach
    void setUp() {
        List<Product> products = Arrays.asList(
                new Burger(1, 50, "Cheeseburger", true), //Cheese or not
                new Pizza(2, 30, "Pepperoni Pizza", true),                // Hot or not
                new Tacos(3, 45, "Tacos", true)              // Spicy or not

        );
        vm = new VendingMachine(products);
    }

    /**
     * Test that adding a valid currency denomination updates the balance correctly.
     */
    @Test
    void testAddValidCurrency() {
        vm.addCurrency(100); // Valid denomination
        assertEquals(100.0, vm.getBalance()); // Balance should reflect the deposit
    }

    /**
     * Test that adding an invalid currency denomination does not change the balance.
     */
    @Test
    void testAddInvalidCurrency() {
        vm.addCurrency(3); // Invalid denomination
        assertEquals(0.0, vm.getBalance()); // Balance should remain unchanged
    }

    /**
     * Test that a product can be successfully purchased when there are enough funds.
     */
    @Test
    void testRequestProductWithSufficientFunds() {
        vm.addCurrency(100); // Add enough money
        Product product = vm.request(1); // Cotton Candy costs 50
        assertNotNull(product); // Product should be returned
        assertEquals(50.0, vm.getBalance()); // Remaining balance should be correct
    }

    /**
     * Test that a product cannot be purchased if there are insufficient funds.
     */
    @Test
    void testRequestProductWithInsufficientFunds() {
        vm.addCurrency(20); // Not enough for Cotton Candy
        Product product = vm.request(1); // Cotton Candy costs 50
        assertNull(product); // Purchase should fail
        assertEquals(20.0, vm.getBalance()); // Balance should remain unchanged
    }

    /**
     * Test that ending the session returns the correct change and resets the balance.
     */
    @Test
    void testEndSessionReturnsCorrectChange() {
        vm.addCurrency(100); // Add money
        vm.request(2); // Mint Drops cost 30
        double change = vm.endSession(); // End session
        assertEquals(70.0, change); // Correct change returned
        assertEquals(0.0, vm.getBalance()); // Balance should be reset
    }

    /**
     * Test that the description of a product is accurate and includes key details.
     */
    @Test
    void testGetDescriptionReturnsCorrectText() {
        String description = vm.getDescription(3); // Sour Sticks
        assertTrue(description.contains("Sour Sticks")); // Name should be included
        assertTrue(description.contains("level")); // Sourness level should be mentioned
    }

    /**
     * Test that all products are listed correctly using their toString() methods.
     */
    @Test
    void testGetProductsReturnsAllItems() {
        String[] items = vm.getProducts();
        assertEquals(4, items.length); // Should list all 4 products
        assertTrue(items[0].contains("Cotton Candy")); // First item check
        assertTrue(items[1].contains("Mint Drops"));   // Second item check
    }

    /**
     * Test that duplicate product IDs trigger a warning but do not prevent setup.
     */
    @Test
    void testDuplicateIdsWarning() {
        List<Product> duplicateProducts = Arrays.asList(
                new Burger(1, 50, "Cheeseburger", true),
                new Tacos(1, 30, "Very Spicy", true) // Duplicate ID
        );
        IVendingMachine vmWithDuplicates = new VendingMachine(duplicateProducts);
        assertEquals(2, vmWithDuplicates.getProducts().length); // Both products are still accepted
    }
}