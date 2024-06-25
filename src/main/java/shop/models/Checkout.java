package shop.models;

import javax.persistence.*;

@Entity
@Table(name = "checkouts")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    private Shop shop;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cashier")
    private Cashier cashier;

    public Checkout(Shop shop){
        this.shop = shop;
    }

    public void assignCashier(Cashier cashier){
        this.cashier = cashier;
    }

    public void removeCashier(Cashier cashier){
        this.cashier = null;
    }

    public int getId(){
        return this.id;
    }

    public Shop getShop(){
        return this.shop;
    }

    public Cashier getCashier(){
        return this.cashier;
    }
}