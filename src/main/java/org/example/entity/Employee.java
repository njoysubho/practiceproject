package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee",schema = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "employee_name")
    private String employeeName;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<EmployeeRecord> employeeRecords;

}
