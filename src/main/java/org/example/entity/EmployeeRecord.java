package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "employee_record",schema = "employee")
@NoArgsConstructor
@Getter
@Setter
public class EmployeeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    private Employee employee;

    @Column(name="details")
    private String details;


}
