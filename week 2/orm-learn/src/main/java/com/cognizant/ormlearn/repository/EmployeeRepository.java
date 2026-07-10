package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

/**
 * Spring Data JPA repository.
 * No implementation needed here - Spring generates save(), findAll(),
 * findById(), delete(), etc. at runtime via a dynamic proxy.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
