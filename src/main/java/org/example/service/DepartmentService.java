package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.util.DepartmentConverter;
import org.example.domain.DepartmentDTO;
import org.example.entity.Department;
import org.example.exception.DepartmentNotFoundException;
import org.example.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.util.DepartmentConverter.toDTO;
import static org.example.util.DepartmentConverter.toDo;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private  final DepartmentRepository departmentRepository;

    @Transactional
    public DepartmentDTO create(DepartmentDTO departmentDTO){
        Department department = toDo(departmentDTO);
        department=departmentRepository.save(department);
        return toDTO(department);
    }

    @Transactional
    public List<DepartmentDTO> getAllDepartments(){
        List<Department> departments=departmentRepository.findAll();
        return departments.stream()
                .map(DepartmentConverter::toDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public DepartmentDTO getDepartmentById(Integer id){
        Department department=departmentRepository.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Employee with id "+id+" does not exists"));
        return DepartmentConverter.toDTO(department);
    }

    @Transactional
    public DepartmentDTO updateDepartment(Integer id, DepartmentDTO departmentDTO){

        Department department =departmentRepository.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Department with id "+id+" does not exists"));
        department.setDepartmentName(departmentDTO.getDeptName());
        Department updatedDepartment = departmentRepository.save(department);
        return toDTO(department);
    }

    @Transactional
    public void delete (Integer id){
        Department department = departmentRepository.findById(id)
                .orElseThrow(()->new DepartmentNotFoundException("Department with id: "+id + "doesn't exist"));
        departmentRepository.delete(department);

    }

    @Transactional
    public DepartmentDTO getDepartmentByName(String departmentName){
        Department department = departmentRepository.findByDepartmentName(departmentName)
                .orElseThrow(()->new DepartmentNotFoundException("No such department exist"));
        return toDTO(department);
    }

}
