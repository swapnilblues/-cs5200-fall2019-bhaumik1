package com.example.demo.daos;

import com.example.demo.models.Course;
import com.example.demo.models.Faculty;
import com.example.demo.models.Section;
import com.example.demo.models.Student;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UniversityImplTest {

  @Autowired
  UniversityImpl universityDao;


  @Test
  public void aTestTruncate() {
    universityDao.truncateDatabase();
  }

  @Test
  public void bTestCreateFaculty() {

    Faculty faculty = new Faculty("Alan", "Turin", "123A", true);
    universityDao.createFaculty(faculty);
    faculty = new Faculty("Ada", "Lovelace", "123B", true);
    universityDao.createFaculty(faculty);
  }

  @Test
  public void cTestCreateStudent() {

    Student student = new Student("Alice", "Wonderland", 2020, 12000);
    universityDao.createStudent(student);
    student = new Student("Bob", "Hope", 2021, 23000);
    universityDao.createStudent(student);
    student = new Student("Charlie", "Brown", 2019, 21000);
    universityDao.createStudent(student);
    student = new Student("Dan", "Craig", 2019, 0);
    universityDao.createStudent(student);
    student = new Student("Edward", "Scissorhands", 2022, 11000);
    universityDao.createStudent(student);
    student = new Student("Frank", "Hebert", 2018, 0);
    universityDao.createStudent(student);
    student = new Student("Gregory", "Peck", 2023, 10000);
    universityDao.createStudent(student);

  }

  @Test
  public void dAddCoursesAuthoredByFaculty() {

    List<Faculty> faculties = universityDao.findAllFaculty();
    Faculty alan = null;
    Faculty ada = null;
    for (Faculty faculty : faculties) {
      if (faculty.getFirstName().equals("Alan")) {
        alan = faculty;
      } else if (faculty.getFirstName().equals("Ada")) {
        ada = faculty;
      }
    }
    Course course1 = new Course("CS1234");
    course1.setAuthor(alan);
    Course course2 = new Course("CS2345");
    course2.setAuthor(alan);
    Course course3 = new Course("CS3456");
    course3.setAuthor(ada);
    Course course4 = new Course("CS4567");
    course4.setAuthor(ada);

    universityDao.createCourse(course1);
    universityDao.createCourse(course2);
    universityDao.createCourse(course3);
    universityDao.createCourse(course4);

  }

  @Test
  public void eAddSectionsForCourses() {
    List<Course> courses = universityDao.findAllCourses();
    Course cs1234 = null;
    Course cs2345 = null;
    Course cs3456 = null;
    for (Course c : courses) {
      if (c.getTitle().equals("CS1234")) {
        cs1234 = c;
      }
      if (c.getTitle().equals("CS2345")) {
        cs2345 = c;
      }
      if (c.getTitle().equals("CS3456")) {
        cs3456 = c;
      }
    }

    Section section1 = new Section("SEC4321", 50);
    section1.setCourse(cs1234);
    Section section2 = new Section("SEC5432", 50);
    section2.setCourse(cs1234);
    Section section3 = new Section("SEC6543", 50);
    section3.setCourse(cs2345);
    Section section4 = new Section("SEC7654", 50);
    section4.setCourse(cs3456);

    universityDao.createSection(section1);
    universityDao.createSection(section2);
    universityDao.createSection(section3);
    universityDao.createSection(section4);

  }

  @Test
  public void fEnrollStudentsForSection() {

    List<Student> students = universityDao.findAllStudents();
    Student a = null;
    Student b = null;
    Student c = null;
    for (Student s : students) {
      if (s.getFirstName().equals("Alice")) {
        a = s;
      }
      if (s.getFirstName().equals("Bob")) {
        b = s;
      }
      if (s.getFirstName().equals("Charlie")) {
        c = s;
      }
    }

    List<Section> sections = universityDao.findAllSections();
    System.out.println(sections.toString());

    Section s4 = null;
    Section s5 = null;
    Section s6 = null;
    for (Section s : sections) {
      if (s.getTitle().equals("SEC4321")) {
        System.out.println(s.getTitle());
        s4 = s;
      }
      if (s.getTitle().equals("SEC5432")) {
        System.out.println(s.getTitle());
        s5 = s;
      }
      if (s.getTitle().equals("SEC6543")) {
        System.out.println(s.getTitle());
        s6 = s;
      }
    }

    universityDao.enrollStudentInSection(a, s4);
    universityDao.enrollStudentInSection(a, s5);
    universityDao.enrollStudentInSection(b, s5);
    universityDao.enrollStudentInSection(c, s6);

  }

  @Test
  public void gValidateNumberOfUsers() {
    assertEquals(9, universityDao.findAllUsers().size());
  }

  @Test
  public void hValidateNumberOfFaculty() {
    assertEquals(2, universityDao.findAllFaculty().size());
  }

  @Test
  public void iValidateNumberOfStudents() {
    assertEquals(7, universityDao.findAllStudents().size());
  }

  @Test
  public void jValidateNumberOfCourses() {
    assertEquals(4, universityDao.findAllCourses().size());
  }

  @Test
  public void kValidateNumberOfSections() {
    assertEquals(4, universityDao.findAllSections().size());
  }

  @Test
  public void lValidateNumberOfCoursesPerAuthor() {
    List<Faculty> faculties = universityDao.findAllFaculty();
    List<Integer> numberOfCourses = new ArrayList<>();
    for (Faculty faculty : faculties) {
      numberOfCourses.add(universityDao.findCoursesForAuthor(faculty).size());
    }
    assertEquals(2, numberOfCourses.get(0).intValue());
    assertEquals(2, numberOfCourses.get(1).intValue());
  }

  @Test
  public void mValidateNumberOfSectionsPerCourse() {
    List<Course> courses = universityDao.findAllCourses();
    for (Course c : courses) {
      switch (c.getTitle()) {
        case "CS1234":
          assertEquals(2, universityDao.findSectionForCourse(c).size());
          break;
        case "CS2345":
        case "CS3456":
          assertEquals(1, universityDao.findSectionForCourse(c).size());
          break;
        case "CS4567":
          assertEquals(0, universityDao.findSectionForCourse(c).size());
          break;
      }
    }
  }

  @Test
  public void nValidateNumberOfStudentsPerSection() {
    List<Section> sections = universityDao.findAllSections();
    for (Section s : sections) {
      switch (s.getTitle()) {
        case "SEC4321":
        case "SEC6543":
          assertEquals(1, universityDao.findStudentsInSection(s).size());
          break;
        case "SEC5432":
          assertEquals(2, universityDao.findStudentsInSection(s).size());
          break;
        case "SEC7654":
          assertEquals(0, universityDao.findStudentsInSection(s).size());
          break;
      }
    }
  }

  @Test
  public void oValidateNumberOfSectionsPerStudent() {
    List<Student> students = universityDao.findAllStudents();
    for (Student s : students) {
      switch (s.getFirstName()) {
        case "Alice":
          assertEquals(2, universityDao.findSectionsForStudent(s).size());
          break;
        case "Bob":
        case "Charlie":
          assertEquals(1, universityDao.findSectionsForStudent(s).size());
          break;
        default:
          assertEquals(0, universityDao.findSectionsForStudent(s).size());
          break;
      }
    }
  }

  @Test
  public void pValidateNumberOfSeatsPerSection() {
    List<Section> sections = universityDao.findAllSections();
    for (Section section : sections) {
      switch (section.getTitle()) {
        case "SEC4321":
        case "SEC6543":
          assertEquals(49, section.getSeats().intValue());
          break;
        case "SEC5432":
          assertEquals(48, section.getSeats().intValue());
          break;
        case "SEC7654":
          assertEquals(50, section.getSeats().intValue());
      }
    }
  }


}


