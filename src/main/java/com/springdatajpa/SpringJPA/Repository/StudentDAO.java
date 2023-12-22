package com.springdatajpa.SpringJPA.Repository;

import com.springdatajpa.SpringJPA.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findByID(int id);
    List<Student> findByFirstName(String firstName);
}
