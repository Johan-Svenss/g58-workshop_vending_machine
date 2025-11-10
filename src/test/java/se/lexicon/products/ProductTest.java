package se.lexicon.products;

import org.junit.jupiter.api.Test;
import se.lexicon.model.product.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    // A simple concrete subclass of Product for testing purposes
    static class TestProduct extends Product {
        public TestProduct(int id, double price, String productName) {
            super(id, price, productName);
        }

        @Override
        public String examine() {
            return "Test examine";
        }

        @Override
        public String use() {
            return "Test use";
        }
    }

    @Test
    void testValidConstruction() {
        Product product = new TestProduct(1, 25.0, "Test Item");

        assertEquals(1, product.getId());
        assertEquals(25.0, product.getPrice());
        assertEquals("Test Item", product.getProductName());
    }

    @Test
    void testSetInvalidId() {
        Product product = new TestProduct(1, 10.0, "Valid");
        product.setId(0); // Invalid ID
        assertEquals(1, product.getId()); // Should remain unchanged
    }

    @Test
    void testSetInvalidPrice() {
        Product product = new TestProduct(1, 10.0, "Valid");
        product.setPrice(-5); // Invalid price
        assertEquals(10.0, product.getPrice()); // Should remain unchanged
    }

    @Test
    void testSetInvalidProductName() {
        Product product = new TestProduct(1, 10.0, "Valid");
        product.setProductName("   "); // Invalid name
        assertEquals("Valid", product.getProductName()); // Should remain unchanged
    }

    @Test
    void testExamineAndUse() {
        Product product = new TestProduct(1, 10.0, "Sample");
        assertEquals("Test examine", product.examine());
        assertEquals("Test use", product.use());
    }
}