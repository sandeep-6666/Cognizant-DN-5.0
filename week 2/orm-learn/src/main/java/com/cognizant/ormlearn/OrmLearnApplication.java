package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.dao.HibernateEmployeeDao;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;
    private static HibernateEmployeeDao hibernateEmployeeDao;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        hibernateEmployeeDao = context.getBean(HibernateEmployeeDao.class);

        testGetAllCountries();
        testAddEmployeeRawHibernate();
        testAddEmployeeSpringDataJpa();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    // Hands-on comparison point #1: raw Hibernate Session/Transaction plumbing
    private static void testAddEmployeeRawHibernate() {
        LOGGER.info("=== Adding employee via raw Hibernate ===");
        Employee employee = new Employee("Asha Rao", "Engineering");
        Integer id = hibernateEmployeeDao.addEmployee(employee);
        LOGGER.info("Hibernate DAO created employee with id={}", id);
    }

    // Hands-on comparison point #2: Spring Data JPA - same outcome, far less code
    private static void testAddEmployeeSpringDataJpa() {
        LOGGER.info("=== Adding employee via Spring Data JPA ===");
        Employee employee = new Employee("Marco Silva", "Finance");
        Employee saved = employeeService.addEmployee(employee);
        LOGGER.info("Spring Data JPA created employee with id={}", saved.getId());
    }
}
