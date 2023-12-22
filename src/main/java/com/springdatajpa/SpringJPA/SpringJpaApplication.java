package com.springdatajpa.SpringJPA;

import com.springdatajpa.SpringJPA.Repository.StudentDAO;
import com.springdatajpa.SpringJPA.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
		};
	}

	static void createStudent(StudentDAO studentDAO){

		Student student1 = new Student("naveen","kumar","naveenofficial001@gmail.com");
		Student student2 = new Student("Gagan","Hanny","hanny.singh986@gmail.com");

		studentDAO.save(student1);
		studentDAO.save(student2);

		Student result = studentDAO.findByID(1);
		if(result!=null){
			System.out.println(result);
		}

		System.out.println(studentDAO.findByFirstName("naveen"));
	}
}


