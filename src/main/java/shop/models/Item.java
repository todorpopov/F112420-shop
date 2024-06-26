package shop.models;

import java.time.LocalDate;
import javax.persistence.*;

import shop.exceptions.InsufficientQuantityException;
import shop.exceptions.ItemSoldOutException;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="shop_id", nullable=true)
    private Shop shop;
    
    @Column(name = "name")
    private String name;

    @Column(name = "delivery-price")
    private double deliveryPrice;

    @Column(name = "final-price")
    private double finalPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "category")
    private Category category;

    @Column(name = "expiry")
    private LocalDate expiry;


    // public Item(){}
    public Item(Shop shop, String name, double deliveryPrice, int quantity, Category category, LocalDate expiry){
        this.shop = shop;
        this.name = name;
        this.deliveryPrice = deliveryPrice;
        this.quantity = quantity;
        this.category = category;
        this.expiry = expiry;
        this.setFinalPrice();
    }

    private void setFinalPrice(){
        double shopMarkupPercentage = this.shop.getMarkupPercentage();
        this.finalPrice = this.deliveryPrice + (shopMarkupPercentage * deliveryPrice);
    }

    public void decreaseQuantity(int decreaseBy) throws Exception{
        if(this.quantity == 0){
            throw new ItemSoldOutException("This item has been sold out");
        }

        if(this.quantity < decreaseBy){
            throw new InsufficientQuantityException("Item quantity is insufficient");
        }

        this.quantity -= decreaseBy;
    }

    public void increaseQuantity(int increaseBy){
        this.quantity += increaseBy;
    }

    public boolean isExpired() {
        LocalDate dateToday = LocalDate.now();
        if(this.expiry.isBefore(dateToday)){
            return true;
        }

        return false;
    }

    public String getStr(){
        return this.name + "(" + this.category + ")" + ": " + this.deliveryPrice + " | " + this.finalPrice;
    }

    public Shop getShop(){
        return this.shop;
    }

    public String getName(){
        return this.name;
    }

    public double getDeliveryPrice(){
        return this.deliveryPrice;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public Category getCategory(){
        return this.category;
    }

    public LocalDate getExpiry(){
        return this.expiry;
    }
}