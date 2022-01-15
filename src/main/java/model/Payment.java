package model;

import lombok.Data;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCreation;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "paymentId", nullable = false)
    private Long paymentId;

    @Column
    private DateTimeAtCreation paymentDate;

    @Column
    private int paymentAmount;

    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Order order;

}
