package model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "`Order`")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderId", nullable = false)
    private Long orderId;

    @Column
    private String status;

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    Customer customer;

}