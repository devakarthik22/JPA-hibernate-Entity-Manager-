package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);

		};


	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student bases on id
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);


		//change firstname to "scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstname("Scooby");

		//update the student
		studentDAO.update(myStudent);


		//display the updated student
		System.out.println("Updated student : "+myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudent=studentDAO.findByLastName("Duck");

		//display the list of students
		for(Student tempStudent:theStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudent=studentDAO.findAll();


		//display a list of students
		for(Student tempStudent:theStudent){

			System.out.println(tempStudent);




		}








	}

	private void readStudent(StudentDAO studentDAO){
		//craete a student object
		System.out.println("Creating new student object ......");
		Student tempStudent=new Student("Daffy","Duck","daffy@luv2code.com");

		//save the student
		System.out.println("Saving the student ......");
		studentDAO.save(tempStudent);


		//display id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Saved student. Generated Id: "+theId);


		System.out.println("Retrieving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);

		System.out.println("Found the student "+myStudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Craeting new 3 Student Object.....");
		Student tempStudent1=new Student("Paul","Doe","paul@luv2code1.com");
		Student tempStudent2=new Student("Marry","Dee","paul@luv2code2.com");
		Student tempStudent3=new Student("Davis","Jay","paul@luv2code3.com");


		System.out.println("Saving the students ......");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Craeting new Student Object.....");
		Student tempStudent=new Student("Paul","Doe","paul@luv2code.com");

		//save the student
		System.out.println("Saving the student ......");
		studentDAO.save(tempStudent);

		//display the id of the object
		System.out.println("Saved Student. Generated id: +"+tempStudent.getId());
	}

}
