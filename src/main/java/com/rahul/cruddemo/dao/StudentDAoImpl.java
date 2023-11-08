package com.rahul.cruddemo.dao;

import com.rahul.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAoImpl implements StudentDAO {
    // define field for Entity manager
    private EntityManager entityManager;

    @Autowired
    public StudentDAoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // inject entity manager using constructor injection

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);


    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student  order by lastName asc", Student.class);


        return theQuery.getResultList();


    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

        // set query parameters
        theQuery.setParameter("theData", theLastName);
        // return query results

        return theQuery.getResultList();
    }
@Transactional
    @Override
    public void update(Student theStudent) {
entityManager.merge(theStudent);
    }
@Transactional
    @Override
    public void delete(Integer id) {
        // retreive the student
    Student student=entityManager.find(Student.class,id);
    // delete the student
    entityManager.remove(student);

    }
@Transactional
    @Override
    public int deleteAll() {

       int numRowDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

    return numRowDeleted;
    }

}
