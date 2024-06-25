package shop.models;

import javax.persistence.*;

@Entity
@Table(name = "cashiers")
public class Cashier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;

    public Cashier(){}
    public Cashier(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }
}