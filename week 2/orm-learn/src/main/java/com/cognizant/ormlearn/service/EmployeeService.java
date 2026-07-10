package com.cognizant.ormlearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

/**
 * Spring Data JPA version of "add an employee".
 * Compare this to HibernateEmployeeDao.addEmployee() - no Session,
 * no Transaction object, no try/catch/finally. @Transactional handles
 * commit/rollback, and save() is inherited free from JpaRepository.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
