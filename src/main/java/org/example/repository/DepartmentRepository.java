package org.example.repository;

import org.example.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    public Optional<Department> findByDepartmentName(String name);
}


