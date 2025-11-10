package se.lexicon.model.product;

/**
 * The Product class is an abstract base class representing a general product
 * in a vending machine or food system. It defines the common properties and
 * behaviors that all specific product types (e.g., Burger, Pizza, Tacos) share.
 *
 */
public abstract class Product {
    private int id;
    private double price;
    private String productName;

    /**
     * Default constructor.
     * Used when no initial values are provided.
     */
    public Product() {
    }

    /**
     * Full constructor.
     * Initializes a product with the given ID, price, and name.
     *
     * @param id           the unique identifier of the product
     * @param price        the price of the product (must be non-negative)
     * @param productName  the name of the product (must not be null or empty)
     */
    public Product(int id, double price, String productName) {
        setId(id);
        setPrice(price);
        setProductName(productName);
    }

    /**
     * Gets the price of the product.
     *
     * @return the price as a double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the product.
     * Prints a warning if the price is negative, but does not assign it.
     *
     * @param price the price to set (must be >= 0)
     */
    public void setPrice(double price) {
        //Check if price is positive
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Warning! Product price can't be negative!");
        }
    }

    /**
     * Gets the product name.
     *
     * @return the name of the product
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the name of the product.
     * If the provided name is null or empty, a warning is printed and the
     * previous value remains unchanged.
     *
     * @param productName the name of the product (cannot be null or empty)
     */
    public void setProductName(String productName) {
        // Check if null or empty
        if (productName == null || productName.isEmpty()) {
            System.out.println("Product needs a proper name!");
        } else {
            this.productName = productName;
        }
    }

    /**
     * Gets the product ID.
     *
     * @return the product ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the product ID.
     * Prints a warning if the ID is negative.
     *
     * @param id the ID to set (must be >= 0)
     */
    public void setId(int id) {
        // Check Id has value
        if( id >= 0) {
            this.id = id;
        } else {
            System.out.println("Invalid Id!");
        }
    }

    /**
     * Abstract method that must be implemented by subclasses.
     * Describes how the product is used (e.g., eaten or consumed).
     *
     * @return a string describing the use of the product
     */
    public abstract String use();

    /**
     * Abstract method that must be implemented by subclasses.
     * Describes the features or details of the product, including price and attributes.
     *
     * @return a string describing the product details
     */
    public abstract String examine();
}