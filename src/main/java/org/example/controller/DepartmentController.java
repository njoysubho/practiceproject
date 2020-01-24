package org.example.controller;

import org.example.domain.DepartmentDTO;
import org.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(path = "/",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentDTO>> getDepartment(){
        return new  ResponseEntity<> (departmentService.getAllDepartments(),HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id")Integer departmentId){
        ResponseEntity<DepartmentDTO> responseEntity;
        DepartmentDTO department = departmentService.getDepartmentById(departmentId);
        responseEntity = new ResponseEntity<>(department, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(path = "/search",method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDTO> getDepartmentByName(@RequestParam("name")String departmentName){
        ResponseEntity<DepartmentDTO> responseEntity;
        DepartmentDTO department = departmentService.getDepartmentByName(departmentName);
        responseEntity = new ResponseEntity<>(department, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(path = "/",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDTO> addDepartments(@RequestBody DepartmentDTO departmentDTO){
        return new ResponseEntity<DepartmentDTO> (departmentService.create(departmentDTO),HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id")Integer deptId){
        return new ResponseEntity<DepartmentDTO>(departmentService.updateDepartment(deptId,departmentDTO),HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentDTO> deleteDepartment(@PathVariable("id")Integer deptId){
        departmentService.delete(deptId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
