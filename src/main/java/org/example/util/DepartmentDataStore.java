package org.example.util;

import org.example.domain.Department;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DepartmentDataStore {

    private Map<Integer,Department> departmentMap = new HashMap<>();
    public List<Department> getAllDepartments(){
        departmentMap.put(1,new Department(1,"Science"));
        departmentMap.put(2,new Department(2,"Commerce"));
        departmentMap.put(3,new Department(3,"Arts"));
        return new ArrayList<>(departmentMap.values());
    }

    public Department saveNewDepartment(Department department){
        department.setDeptId(new Random().nextInt());
        departmentMap.put(department.getDeptId(),department);
        return department;
    }
}
