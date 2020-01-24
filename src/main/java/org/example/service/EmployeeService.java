package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.util.EmployeeConverter;
import org.example.domain.EmployeeDTO;
import org.example.entity.Employee;
import org.example.exception.EmployeeNotFoundException;
import org.example.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.example.util.EmployeeConverter.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private  final EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeDTO create(EmployeeDTO employeeDTO){
        //validation logic
        Employee employee = toDO(employeeDTO);
        employee=employeeRepository.save(employee);
        return toDTO(employee);
    }

    @Transactional
    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream()
                .map(EmployeeConverter::toDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public EmployeeDTO getEmployeeById(Integer id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" does not exists"));
        return EmployeeConverter.toDTO(employee);
    }

    @Transactional
    public EmployeeDTO updateEmployee(Integer id,EmployeeDTO employeeDTO){

        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" does not exists"));
        employee.setEmployeeName(employeeDTO.getName());
        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeConverter.toDTO(employee);
    }

    @Transactional
    public void delete(Integer id){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" does not exists"));
        employeeRepository.delete(employee);
    }
}
