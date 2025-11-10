package se.lexicon.model.product;

/**
 * The Pizza class represents a type of Product (inherits from Product)
 * with an additional unique property: whether it is hot or not.
 */
public class Pizza extends Product {

    // Unique field specific to Pizza
    private boolean isHot;

    /**
     * Constructor without the isHot parameter.
     * Creates a Pizza with default temperature (false by default).
     *
     * @param id           unique identifier for the pizza (inherited from Product)
     * @param price        price of the pizza
     * @param productName  name of the pizza
     */
    public Pizza(int id, double price, String productName, boolean isHot) {
        super(id, price, productName);
        this.isHot = isHot;
    }
    /**
     * Getter for isHot.
     *
     * @return true if the pizza is hot, false otherwise
     */
    public boolean isHotOrNot() {
        return isHot;
    }

    /**
     * Setter for isHot.
     *
     * @param isHot true if the pizza should be hot, false otherwise
     */
    public void isHotOrNot(boolean isHot) {
        isHot = isHot;
    }

    /**
     * Describes using (eating) the pizza.
     * Overrides the abstract method from Product.
     *
     * @return A string describing how the pizza is used (eaten).
     */
    @Override
    public String use() {
        return "This lunch time i ate a " + this.getProductName() + " and it was verry delicious!";
    }

    /**
     * Gives a detailed description of the pizza.
     * Overrides the abstract method from Product.
     *
     * @return A string describing whether the pizza is hot and its price.
     */
    @Override
    public String examine() {
        return this.getProductName() + (this.isHotOrNot() ? " is very hot and " : "freshly baked and ") + " costs " + this.getPrice() + " SEK.";
    }

    /**
     * Returns a string representation of the pizza object.
     * Useful for debugging or listing product details.
     *
     * @return A formatted string containing pizza information.
     */
    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getProductName() +
                ", IsHot" + this.isHotOrNot() + // unique field. replace in other classes
                ", Price" + this.getPrice() +
                " SEK";
    }
}

