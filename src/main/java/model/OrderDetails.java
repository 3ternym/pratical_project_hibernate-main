package model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;

@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderDetailsId", nullable = false)
    private Long orderDetailsId;

    @Column
    private LocalDateTime orderStartDate;

    @Column
    private LocalDateTime orderEndDate;

    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    Order order;

    @OneToOne
    @JoinColumn(name = "providerId", referencedColumnName = "providerId")
    ProductProvider productProvider;



}
