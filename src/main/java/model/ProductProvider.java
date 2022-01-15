package model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProductProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "providerId", nullable = false)
    private Long providerId;

    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    Product product;


}
