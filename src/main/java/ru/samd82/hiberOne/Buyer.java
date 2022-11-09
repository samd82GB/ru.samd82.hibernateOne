package ru.samd82.hiberOne;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "buyers")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany
    @JoinTable (name = "buyers_products",
                joinColumns = @JoinColumn (name = "buyer_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;



    public Buyer() {
    }

    public Buyer(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
