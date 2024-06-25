package shop.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "receipts")
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "number")
    public static int number;

    @Column(name = "shop")
    private Shop shop;

    @Column(name = "checkout")
    private Checkout checkout;

    @Column(name = "items")
    private HashMap<Item, Integer> items;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "total")
    private float total;


    public Receipt(Shop shop, Checkout checkout, HashMap<Item, Integer> items, float total){
        this.shop = shop;
        this.checkout = checkout;
        this.items = items;
        this.total = total;

        this.date = LocalDate.now();
        Receipt.number++;
    }

    public void print(){
        System.out.println(
            "Receipt ID: " + this.id + "\n" +
            "Receipt number: " + Receipt.number + "\n" +
            "Shop: " + this.shop.getName() + "\n" +
            "Checkout id: " + this.checkout.getId() + "\n" +
            "Date: " + this.date + "\n" +
            "Total: " + this.total + "\n" +
            "Items:\n"
        );
        items.forEach((item, quantity) -> {
            System.out.println(quantity + ": " + item.getStr());
        });
    }

    public String getStr(){
        return this.id + " " + this.shop + " " + this.date;
    }
}
