package org.example;

import org.example.domain.EmployeeDTO;
import org.example.entity.Employee;

public class EmployeeConverter {

    public static Employee toDO(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDTO.getName());
        return employee;
    }

    public static EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getEmployeeName());
        return employeeDTO;
    }
}
