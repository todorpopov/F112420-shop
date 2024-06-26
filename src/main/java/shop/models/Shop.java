package shop.models;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "markup-percentage")
    private double markupPercentage;

    @OneToMany
    @JoinColumn(name = "shop_id", nullable = true)
    private List<Checkout> checkouts;
    
    @OneToMany
    @JoinColumn(name = "shop_id", nullable = true)
    private List<Item> items;


    public Shop(String name, double markupPercentage){
        this.name = name;
        this.markupPercentage = markupPercentage;
        this.checkouts = null;
        this.items = null;
    }

    public String getStr(){
        return this.id + " " + this.name + " " + this.markupPercentage;
    }

    public void addCheckout(Checkout checkout){
        this.checkouts.add(checkout);
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getName() {
        return this.name;
    }

    public double getMarkupPercentage() {
        return this.markupPercentage;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public List<Checkout> Checkouts(){
        return this.checkouts;
    }
}
