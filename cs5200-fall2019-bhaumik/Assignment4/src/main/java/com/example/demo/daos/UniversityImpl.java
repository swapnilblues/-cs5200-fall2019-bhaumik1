package com.example.demo.daos;

import com.example.demo.models.Course;
import com.example.demo.models.Enrollment;
import com.example.demo.models.Faculty;
import com.example.demo.models.Person;
import com.example.demo.models.Section;
import com.example.demo.models.Student;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.EnrollmentRepository;
import com.example.demo.repositories.FacultyRepository;
import com.example.demo.repositories.PersonRepository;
import com.example.demo.repositories.SectionRepository;
import com.example.demo.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;


@Controller
public class UniversityImpl implements UniversityDao {


//  @Autowired
//  public UniversityImpl(PersonRepository personRepository, FacultyRepository facultyRepository, StudentRepository studentRepository, CourseRepository courseRepository, SectionRepository sectionRepository, EnrollmentRepository enrollmentRepository) {
//    this.personRepository = personRepository;
//    this.facultyRepository = facultyRepository;
//    this.studentRepository = studentRepository;
//    this.courseRepository = courseRepository;
//    this.sectionRepository = sectionRepository;
//    this.enrollmentRepository = enrollmentRepository;
//  }

  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private FacultyRepository facultyRepository;
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private CourseRepository courseRepository;
  @Autowired
  private SectionRepository sectionRepository;
  @Autowired
  private EnrollmentRepository enrollmentRepository;


  public void truncateDatabase() {


    enrollmentRepository.deleteAll();
    sectionRepository.deleteAll();
    courseRepository.deleteAll();
    facultyRepository.deleteAll();
    personRepository.deleteAll();
    studentRepository.deleteAll();








  }

  public Faculty createFaculty(Faculty faculty) {
    return facultyRepository.save(faculty);
  }

  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  public Course createCourse(Course course) {
    return courseRepository.save(course);
  }

  public Section createSection(Section section) {
    return sectionRepository.save(section);
  }

  public Course addSectionToCourse(Section section, Course course) {
    course.getListOfSections().add(section);
    section.setCourse(course);
    return courseRepository.save(course);
  }

  public Course setAuthorForCourse(Faculty faculty, Course course) {
    course.setAuthor(faculty);
    return courseRepository.save(course);
  }

  public Boolean enrollStudentInSection(Student student, Section section) {
    if (section.getSeats() <= 0) {
      return false;
    }
    student.enrollSection(section);
    section.setSeats(section.getSeats() - 1);
    sectionRepository.save(section);
    return true;
  }

  public List<Person> findAllUsers() {
    return (List<Person>) personRepository.findAll();
  }

  public List<Faculty> findAllFaculty() {
    return (List<Faculty>) facultyRepository.findAll();
  }

  public List<Student> findAllStudents() {
    return (List<Student>) studentRepository.findAll();
  }

  public List<Course> findAllCourses() {
    return (List<Course>) courseRepository.findAll();
  }

  public List<Section> findAllSections() {
    return (List<Section>) sectionRepository.findAll();
  }

  public List<Course> findCoursesForAuthor(Faculty faculty) {
    return new ArrayList<>(faculty.getAuthoredCourses());
  }

  public List<Section> findSectionForCourse(Course course) {
    return new ArrayList<>(course.getListOfSections());
  }

  public List<Student> findStudentsInSection(Section section) {
    Set<Enrollment> enrollments = section.getEnrollments();
    List<Student> students = new ArrayList<>();

    for (Enrollment enrollment : enrollments) {
      Student student = enrollment.getStudent();
      students.add(student);
    }
    return students;
  }

  public List<Section> findSectionsForStudent(Student student) {
   Set<Enrollment> enrollments = student.getEnrollments();
   List<Section> sections = new ArrayList<>();
   for(Enrollment enrollment : enrollments) {
      Section section = enrollment.getSection();
      sections.add(section);
   }
   return sections;
  }

}
