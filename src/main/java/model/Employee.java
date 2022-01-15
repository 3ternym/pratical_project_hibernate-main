package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employeeId", nullable = false)
    private Long employeeId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;
}
