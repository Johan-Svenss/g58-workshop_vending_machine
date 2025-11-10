package se.lexicon.model;

import se.lexicon.model.product.Product;

import java.util.List;

public class VendingMachine implements IVendingMachine {

    //Fields
    private List<Product> products;
    private int balance = 0;
    private final int[] validatedDenominations = {1, 2, 5, 10 ,20 , 50 ,100, 200, 500, 1000};

    //Constructor

    public VendingMachine(List<Product> productList) {
        this.products = productList;

    }
    //Setter for products
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    // Setter for balance
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void addCurrency(double amount) {
        // Loop through the list of valid denominations
        for (int valid : validatedDenominations) {
            // If the inserted amount matches a validation denomination
            if (amount == valid){
                // Add the amount to the current balance
                setBalance(getBalance() + (int) amount);
            }

        }
        // If the amount is not valid, notify the user
        System.out.println("Invalid denomination: " + amount);
    }

    @Override
    public int getBalance() {
        //Return the current balance
        return balance;
    }

    @Override
    public Product request(int id) {
        for (Product p : products){ // for each -> equally to for (int i = 0....) takes at the beginning the first index
            // Checking if the Id is
            // matching with the product list
            // from the input on the vending maschine
            if( p.getId() == id){
                // Checking, if enough monay is in the
                // deposit of the customer to buy the product
                if (getBalance() >= p.getPrice()){
                    // deducting from the deposit
                    setBalance(getBalance() - (int) p.getPrice());
                    // return the product
                    return p;
                }
                else {
                    //Not enough money
                    System.out.println("You don't have enough money on your account!");
                    return null;
                }
            } else{
                //Product with given ID dont exist
                System.out.println("No product found with this id: " + id + "!");
                return null;
            }
        }
        return null;
    }


    @Override
    public String getDescription(int id) {
        for (Product p : products) { // for each -> equally to for (int i = 0....) takes at the beginning the first index
            // Checking if the Id is
            // matching with the product list
            // from the input on the vending machine
            if (p.getId() == id) {
                return p.examine();
            } else {
                System.out.println("No product found with that ID");
            }
        }
        return "Product not found";
    }

    @Override
    public String[] getProducts() {
            // 1. Create a returnable type -> String[]
            // 2. declare the returnable type with the same
            // length of the existing list
            String[] productList = new String[products.size()];
            // 3. Loop over the existing product list
            // 4. fill the new returnable item by index
            // with the product id, name, price
            for (int i = 0; i < products.size(); i++) {
                // Product product = products.get(i); // <- equivalent to arrays products[i]
                // productList[i] = "ID: " + product.getId() +
                //         ", Name: " + product.getProductName() +
                //         ", Price: " + product.getPrice() + " SEK";
                productList[i] = products.get(i).toString();
            }
            // 5. return the returnable list without type casting
            return productList;
        }

    @Override
    public int endSession() {
        // Store the current balance top return as change
        double change = getBalance();

        // Reset the current balance after procedure
        setBalance(0);

        return (int) change;
    }

}
