package se.lexicon.model.product;

/**
 * The Burger class represents a type of Product (inherits from Product)
 * with an additional unique property: whether it has cheese or not.
 */
public class Burger extends Product{

    // Unique field specific to Burger
    private boolean hasCheese;

    /**
     * Constructor for Burger.
     *
     * @param id           unique identifier for the burger (inherited from Product)
     * @param price        price of the burger
     * @param productName  name of the burger
     * @param hasCheese    true if the burger has cheese, false otherwise
     */
    public Burger(int id, double price, String productName, boolean hasCheese) {
        super(id, price, productName);
        setHasCheese(hasCheese);
    }
    /**
     * Getter for the hasCheese field.
     *
     * @return true if the burger has cheese, false otherwise
     */
    public boolean hasCheeseOnIt() {
        return hasCheese;
    }

    /**
     * Setter for the hasCheese field.
     *
     * @param hasCheese true if burger should have cheese, false otherwise
     */
    public void setHasCheese(boolean hasCheese) {
        this.hasCheese = hasCheese;
    }

    /**
     * Provides a description of using the burger.
     * Overrides the abstract method from Product.
     *
     * @return A string describing how the burger is eaten.
     */
    @Override
    public String use() {
        return "This dinner I ate a "
                + this.getProductName() + ""
                + (this.hasCheeseOnIt() ?
                " with cheese"
                : "without chese")
                + "!";
    }

    /**
     * Gives a detailed description of the burger.
     * Overrides the abstract method from Product.
     *
     * @return A string describing the burger's properties and price.
     */
    @Override
    public String examine() {
        return this.getProductName() + (this.hasCheeseOnIt() ? " has cheese on it and " : " has no cheese on it and ") + " costs " + this.getPrice() + " SEK.";
    }

    /**
     * Returns a string representation of the burger object.
     * This is helpful for debugging or displaying burger info in a list.
     *
     * @return A formatted string containing burger details.
     */
    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getProductName() +
                ", HasCheese" + this.hasCheeseOnIt() + // uniwue field. replace in other classes
                ", Price" + this.getPrice() +
                " SEK";
    }
}
