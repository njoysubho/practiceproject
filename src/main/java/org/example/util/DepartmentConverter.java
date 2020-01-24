package org.example.util;

import org.example.domain.DepartmentDTO;
import org.example.entity.Department;

public class DepartmentConverter {
    public static Department toDo (DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setDepartmentName(departmentDTO.getDeptName());
        return department;
    }

    public static DepartmentDTO toDTO (Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDeptId(department.getId());
        departmentDTO.setDeptName(department.getDepartmentName());
        return departmentDTO;
    }
}
