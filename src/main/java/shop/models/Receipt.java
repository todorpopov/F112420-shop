package shop.models;

import java.time.LocalDate;
import java.util.HashMap;
import javax.persistence.*;

@Entity
@Table(name = "receipts")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "number")
    public static int number;

    @Column(name = "shop-name")
    private String shopName;

    @Column(name = "checkout-id")
    private int checkoutId;

    @Column(name = "items")
    private HashMap<Item, Integer> items;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total")
    private double total;


    public Receipt(){}
    public Receipt(Shop shop, Checkout checkout, HashMap<Item, Integer> items, double total){
        this.shopName = shop.getName();
        this.checkoutId = checkout.getId();
        this.items = items;
        this.total = total;

        this.date = LocalDate.now();
        Receipt.number++;
    }

    public void print(){
        System.out.println(
            "Receipt ID: " + this.id + "\n" +
            "Receipt number: " + Receipt.number + "\n" +
            "Shop: " + this.shopName + "\n" +
            "Checkout id: " + this.checkoutId + "\n" +
            "Date: " + this.date + "\n" +
            "Total: " + this.total + "\n" +
            "Items:\n"
        );
        items.forEach((item, quantity) -> {
            System.out.println(quantity + ": " + item.getStr());
        });
    }

    public String getStr(){
        return this.id + " " + this.shopName + " " + this.date;
    }
}
