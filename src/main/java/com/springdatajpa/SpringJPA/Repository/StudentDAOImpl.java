package com.springdatajpa.SpringJPA.Repository;

import com.springdatajpa.SpringJPA.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);

    }

    @Override
    public Student findByID(int id) {
      return entityManager.find(Student.class,id);

    }

    @Override
    public List<Student> findByFirstName(String firstname) {

        TypedQuery<Student> query = entityManager.createQuery("from Student where firstName=:theData", Student.class);
        query.setParameter("theData",firstname);
        List<Student> resultList = query.getResultList();

        return resultList;
    }
}
