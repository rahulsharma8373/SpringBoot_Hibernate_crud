package com.rahul.cruddemo;

import com.rahul.cruddemo.dao.StudentDAO;
import com.rahul.cruddemo.entity.Student;
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
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        // here we use lambda expression
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudent(studentDAO);
            // readStudent(studentDAO);
            //queryForStudentS(studentDAO);
       //queryForStudentlastName(studentDAO);
//  updateStudent(studentDAO);
       //     deleteStudent(studentDAO);

    // deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
int numRowsDeleted=studentDAO.deleteAll();
        System.out.println("Delete row count: " + numRowsDeleted);

    }

    private void deleteStudent(StudentDAO studentDAO) {
    int stuId=4;
        System.out.println("deleting student id: " + stuId);
        studentDAO.delete(stuId);
    }

    private void updateStudent(StudentDAO studentDAO) {
   // retrieve student based on the id:

        int studentId=1;
        System.out.println("Getting student with id: " + studentId);
Student myStudent=studentDAO.findById(studentId);
// change firstname to "scoop"

        myStudent.setFirstName("scoop");
        studentDAO.update(myStudent);
        System.out.println("update student"+myStudent);




    }

    private void queryForStudentlastName(StudentDAO studentDAO) {
   // get a list of students
        List<Student> theStudent=studentDAO.findByLastName("sam");
        // display list of student
        for (Student tempStudent:theStudent) {
            System.out.println(tempStudent);
        }
    }


    private void queryForStudentS(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();
        for (Student tempstudent : theStudents) {


            System.out.println(tempstudent);


        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("creating new  3 student object...");
        Student tempStudent = new Student("rahul", "doe", "john@123com");

        // save the student
        System.out.println("saving the student");
        studentDAO.save(tempStudent);
        // retrieve student based on the id: primary key
        int thisid = tempStudent.getId();


        System.out.println("saved " + thisid);
        Student myStudent = studentDAO.findById(thisid);

// display the student
        System.out.println("found the student" + myStudent);

    }

    private void createMultipleStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("creating new  3 student object...");
        Student tempStudent1 = new Student("john", "doe", "john@123com");
        Student tempStudent2 = new Student("marry", "pub", "pub@123com");
        Student tempStudent3 = new Student("bobita", "sam", "kum@123com");
// save the student

        System.out.println("savin the student");

        studentDAO.save(tempStudent1);

        studentDAO.save(tempStudent2);

        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {


        // create the student object
        System.out.println("creating new student object...");
        Student tempStudent = new Student("Paul", "doe", "paul@123com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the save student

        System.out.println("saved Student generated id: " + tempStudent.getId());

    }

}