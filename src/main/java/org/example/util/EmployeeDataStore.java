package org.example.util;

import org.example.domain.EmployeeDTO;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class EmployeeDataStore {
    private Map<Integer, EmployeeDTO> employeeMap = new HashMap<>();
    private Random random;
    @PostConstruct
    public void init(){
        random = new Random();
        employeeMap.put(23,new EmployeeDTO("abc",23));
        employeeMap.put(45,new EmployeeDTO("def",45));
    }

    public List<EmployeeDTO> getAllEmployees(){
        return new ArrayList<>(employeeMap.values());
    }

    public EmployeeDTO save(EmployeeDTO employee){
        employee.setId(random.nextInt());
        employeeMap.put(employee.getId(),employee);
        return employee;
    }

    public EmployeeDTO update(EmployeeDTO employee){
        employeeMap.put(employee.getId(),employee);
        return employee;
    }

    public void delete(EmployeeDTO employee){
        employeeMap.remove(employee.getId());
    }

    public Map<Integer, EmployeeDTO> getEmployeeMap(){
        return employeeMap;
    }
}
