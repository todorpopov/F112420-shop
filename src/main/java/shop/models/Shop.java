package shop.models;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "markup-percentage")
    private float markupPercentage;

    @OneToMany(mappedBy = "shop")
    private Set<Checkout> checkouts;
    
    @OneToMany(mappedBy="shop")
    private Set<Item> items;


    public Shop(String name, float markupPercentage){
        this.name = name;
        this.markupPercentage = markupPercentage;
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

    public float getMarkupPercentage() {
        return this.markupPercentage;
    }

    public Set<Item> getItems(){
        return this.items;
    }

    public Set<Checkout> Checkouts(){
        return this.checkouts;
    }
}
