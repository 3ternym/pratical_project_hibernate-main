package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", nullable = false)
    private Long productId;

    @Column
    private String productName;

    @Column
    private String description;

    @Column
    private double price;
}
