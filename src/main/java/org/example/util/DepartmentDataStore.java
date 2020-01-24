package org.example.util;

import org.example.domain.DepartmentDTO;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DepartmentDataStore {

    private Map<Integer, DepartmentDTO> departmentMap = new HashMap<>();
    public List<DepartmentDTO> getAllDepartments(){
        /*departmentMap.put(1,new Department(1,"Science"));
        departmentMap.put(2,new Department(2,"Commerce"));
        departmentMap.put(3,new Department(3,"Arts"));*/
        return new ArrayList<>(departmentMap.values());
    }

    public DepartmentDTO saveNewDepartment(DepartmentDTO departmentDTO){
        departmentDTO.setDeptId(new Random().nextInt());
        departmentMap.put(departmentDTO.getDeptId(), departmentDTO);
        return departmentDTO;
    }

    public DepartmentDTO update(DepartmentDTO departmentDTO){
        departmentMap.put(departmentDTO.getDeptId(), departmentDTO);
        return departmentDTO;
    }

    public void delete (DepartmentDTO departmentDTO){
        departmentMap.remove(departmentDTO.getDeptId());
    }
}
