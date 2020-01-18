package org.example.controller;

import org.example.domain.Department;
import org.example.util.DepartmentDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class DepartmentController {
    @Autowired
    private DepartmentDataStore departmentDataStore;

    @RequestMapping(path = "/departments",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Department>> getDepartment(){
        return new  ResponseEntity<> (departmentDataStore.getAllDepartments(),HttpStatus.OK);
    }

    @RequestMapping(path = "/departments/{deptName}",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Department>> getDepartmentByName(@PathVariable("deptName")String departmentName){
        return new  ResponseEntity<> (departmentDataStore.getAllDepartments(),HttpStatus.OK);
    }

    @RequestMapping(path = "/departments",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> addDepartments(@RequestBody Department department){
        return new ResponseEntity<Department> (departmentDataStore.saveNewDepartment(department),HttpStatus.CREATED);
    }
}
