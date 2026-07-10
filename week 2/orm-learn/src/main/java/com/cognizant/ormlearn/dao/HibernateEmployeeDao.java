package com.cognizant.ormlearn.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.ormlearn.model.Employee;

import jakarta.persistence.EntityManagerFactory;

/**
 * Raw Hibernate version of "add an employee" - no Spring Data JPA involved.
 * This is the manual-plumbing style: open a Session, start a Transaction,
 * save, commit, catch/rollback on failure, close in finally.
 *
 * Compare addEmployee() here (~15 lines of resource management) to
 * EmployeeService.addEmployee() (1 line, @Transactional handles the rest).
 *
 * Note: the SessionFactory is obtained by unwrapping Spring Boot's
 * auto-configured EntityManagerFactory, since Spring Boot doesn't wire up
 * a standalone Hibernate SessionFactory bean by default. This still uses
 * the exact same Session/Transaction API you'd get from a hand-built
 * hibernate.cfg.xml + Configuration().buildSessionFactory() setup.
 */
@Component
public class HibernateEmployeeDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    // Note: session.save() is deprecated in Hibernate 6 (in favor of persist()),
    // but kept here since it's what the original comparison snippet used and
    // it still compiles/runs with a deprecation warning.
    public Integer addEmployee(Employee employee) {
        SessionFactory factory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }
}
