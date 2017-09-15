
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Storehouse {
    private Map<String, Integer> storeHouse;
    private Map<String, Integer> stockHouse;
    
    public Storehouse() {
        this.storeHouse = new HashMap<String, Integer>();
        this.stockHouse = new HashMap<String, Integer>();
    }
    
    public int price(String product) {
        for (String pro : this.storeHouse.keySet()) {
            if (product.equals(pro)) {
                return this.storeHouse.get(pro);
            } 
        }
        return -99;
    }
    
    public void addProduct(String product, int price, int stock) {
        this.storeHouse.put(product, price);
        this.stockHouse.put(product, stock);
    }
    
    public int stock(String product) {
        for(String pro : this.stockHouse.keySet()) {
            if (product.equals(pro)) {
                return this.stockHouse.get(pro);
            }
        }
        return 0;
    }
    
    public boolean take(String product) {
        for (String pro : this.stockHouse.keySet()) {
            if (product.equals(pro)) {
                if (this.stockHouse.get(pro) > 0) {
                    this.stockHouse.put(pro, this.stock(product) - 1);
                    return true;
                }
            }
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> newSet = this.storeHouse.keySet();
        return newSet;
    }
}

public class Purchase {
    
    private String product;
    private int amount;
    private int unitPrice;
    
    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        return this.amount * this.unitPrice;
    }
    
    public void increaseAmount() {
        this.amount++;
    }
    @Override
    public String toString() {
        return this.product + ": " + this.amount;
    }
}

public class ShoppingBasket {
    private Map<String, Purchase> basket;
    
    public ShoppingBasket() {
        this.basket = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price) {
        if (this.basket.containsKey(product)) {
            this.basket.get(product).increaseAmount();
        } else {
            Purchase newPurchase = new Purchase(product, 1, price);
            this.basket.put(product, newPurchase);
        }
    }
    
    public int price() {
        int priceOfPurchase = 0;
        for (Purchase pur : this.basket.values()) {
            priceOfPurchase += pur.price();
        }
        return priceOfPurchase;
    }
    
    public void print() {
       for (Purchase pur : this.basket.values()) {
           System.out.println(pur);
       } 
    }
}

public class Shop {
    private Storehouse store;
    private Scanner reader;

    public Shop(Storehouse store, Scanner reader) {
        this.store = store;
        this.reader = reader;
    }

    // the method to deal with a customer in the shop
    public void manage(String customer) {
        ShoppingBasket basket = new ShoppingBasket();
        System.out.println("Welcome to our shop " + customer);
        System.out.println("below is our sale offer:");

        for (String product : store.products()) {
            System.out.println( product );
        }

        while (true) {
            System.out.print("what do you want to buy (press enter to pay):");
            String product = reader.nextLine();
            if (product.isEmpty()) {
                break;
            } else if (this.store.take(product)) {
                basket.add(product, this.store.price(product));
            }

            // here, you write the code to add a product to the shopping basket, if the storehouse is not empty
            // and decreases the storehouse stocks
            // do not touch the rest of the code!

        }

        System.out.println("your purchases are:");
        basket.print();
        System.out.println("basket price: " + basket.price());
    }
}

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write some test code here
    Storehouse store = new Storehouse();
    store.addProduct("coffee", 5, 10);
    store.addProduct("milk", 3, 20);
    store.addProduct("milkbutter", 2, 55);
    store.addProduct("bread", 7, 8);

    Shop shop = new Shop(store, new Scanner(System.in));
    shop.manage("Pekka");
    }
}
