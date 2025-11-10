package se.lexicon.model;

import se.lexicon.model.product.Product;
/**
 * The VendingMachine interface defines the contract for a vending machine system.
 * It specifies the methods required for handling currency, selecting products,
 * viewing available items, and managing the user session.
 *
 */
public interface IVendingMachine {
    public void addCurrency(double amount);
    public int getBalance();
    public Product request(int id);
    public int endSession();
    public String getDescription(int id);
    public String[] getProducts();

}
