package shop.models;

import javax.persistence.*;

@Entity
@Table(name = "cashiers")
public class Cashier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private float salary;


    public Cashier(String name, float salary){
        this.name = name;
        this.salary = salary;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public float getSalary(){
        return this.salary;
    }
}