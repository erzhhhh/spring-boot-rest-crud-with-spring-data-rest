package com.erzhenika.springboot.cruddemo.dao;

import com.erzhenika.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // no need to write any code LOL!

}
