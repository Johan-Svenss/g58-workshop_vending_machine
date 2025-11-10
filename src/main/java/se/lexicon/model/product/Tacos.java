package se.lexicon.model.product;

/**
 * The Tacos class represents a type of Product (inherits from Product)
 * with an additional unique property: whether it is spicy or not.
 */
public class Tacos extends Product {

    // Unique field specific to Tacos
    private boolean isSpicy;

    /**
     * Full constructor for Tacos including spiciness flag.
     *
     * @param id           unique identifier for the taco (inherited from Product)
     * @param price        price of the taco
     * @param productName  name of the taco
     * @param isSpicy      true if the taco is spicy, false otherwise
     */
    public Tacos(int id, double price, String productName, boolean isSpicy) {
        super(id, price, productName);
        this.isSpicy = isSpicy;
    }

    /**
     * Getter for isSpicy.
     *
     * @return true if the taco is spicy, false otherwise
     */
    public boolean isSpicy() {
        return isSpicy;
    }

    /**
     * Setter for isSpicy.
     *
     * @param spicy true if the taco should be spicy, false otherwise
     */
    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    /**
     * Describes using (eating) the taco.
     * Overrides the abstract method from Product.
     *
     * @return A string describing how the taco is eaten.
     */
    @Override
    public String use() {
        return "This lunch time i ate a " + this.getProductName() + " and it was very delicious!";
    }

    /**
     * Gives a detailed description of the taco.
     * Overrides the abstract method from Product.
     *
     * @return A string describing whether the taco is spicy and its price.
     */
    @Override
    public String examine() {
        return this.getProductName() + (this.isSpicy() ? " is very spicy and " : "is not so spicy and ") + " costs " + this.getPrice() + " SEK.";
    }

    /**
     * Returns a string representation of the taco object.
     * Useful for debugging or listing product details.
     *
     * @return A formatted string containing taco information.
     */
    @Override
    public String toString() {
        return "ID: " + this.getId() +
                ", Name: " + this.getProductName() +
                ", IsSpicy" + this.isSpicy + // uniwue field. replace in other classes
                ", Price" + this.getPrice() +
                " SEK";
    }
}