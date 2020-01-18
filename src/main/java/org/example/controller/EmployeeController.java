package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.EmployeeDTO;
import org.example.exception.EmployeeNotFoundException;
import org.example.service.EmployeeService;
import org.example.util.EmployeeDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmployeeController {


    private final EmployeeService employeeService;


    /*@RequestMapping(path = "/employees",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployees(){
        Employee employee1 = new Employee("abc",23);
        Employee employee2 = new Employee("def",45);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }*/

    @RequestMapping(path = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(path = "/employees/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> getEmployeesById(@PathVariable("id") Integer employeeId) {
        ResponseEntity<EmployeeDTO> responseEntity;
        EmployeeDTO employee = employeeService.getEmployeeById(employeeId);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Etag", "abc12233454");
        responseEntity = new ResponseEntity<>(employee, httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    /*@RequestMapping(path = "/employees",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployeesBySearchId(@RequestParam(name="id",required = false) String employeeId){
        ResponseEntity<Employee> responseEntity;
        Map<Integer,Employee> employeeMap = dataStore.getEmployeeMap();
        Employee employee = employeeMap.get(Integer.parseInt(employeeId));
        if(employee != null){
            responseEntity = new ResponseEntity<>(employee,HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }*/

    @RequestMapping(path = "/employees", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employee) {
        EmployeeDTO savedEmployee = employeeService.create(employee);
        return new ResponseEntity<EmployeeDTO>(savedEmployee, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/employees/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employee, @PathVariable("id") Integer id) {

        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id,employee);
        return new ResponseEntity<EmployeeDTO>(updatedEmployee, HttpStatus.OK);
    }

    @RequestMapping(path = "/employees/{id}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
