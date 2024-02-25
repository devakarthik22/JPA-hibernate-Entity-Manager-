package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO {


    //define fields for entity manager
    private EntityManager entityManager;


    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;

    }




    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);


    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        //fileds of java enity and not the database columsn names
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastname asc",Student.class);


        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //jpql named parameters are prefixed with a colon : like here the theData

        TypedQuery<Student> theQuery=entityManager.createQuery(
                "FROM Student WHERE lastname=:theData",Student.class);

        //set query parameters
        theQuery.setParameter("theData",theLastName);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);


    }


}




