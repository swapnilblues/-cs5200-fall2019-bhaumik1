package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student extends Person {



  private Integer gradYear;
  private long scholarship;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @OneToMany(mappedBy="student", cascade = CascadeType.ALL)//fetch = FetchType.EAGER, cascade = CascadeType.ALL)//, orphanRemoval = true)
  @JsonIgnore
  private Set<Enrollment> enrollments;

  public Student() {
    super();
  }

  public Student(String username, String password, String firstName, String lastName, Integer gradYear,
                 long scholarship) {
    super(username, password, firstName, lastName);
    this.gradYear = gradYear;
    this.scholarship = scholarship;
  }

  public Student(String firstName, String lastName, Integer gradYear, long scholarship) {
    super(firstName, lastName);
    this.gradYear = gradYear;
    this.scholarship = scholarship;
  }

  public Integer getGradYear() {
    return gradYear;
  }

  public void setGradYear(Integer gradYear) {
    this.gradYear = gradYear;
  }

  public long getScholarship() {
    return scholarship;
  }

  public void setScholarship(long scholarship) {
    this.scholarship = scholarship;
  }

  public Set<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(Set<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }

  public void enrollSection(Section section) {
    Enrollment enrollment = new Enrollment(this, section);
    this.enrollments.add(enrollment);
    section.getEnrollments().add(enrollment);
  }

  @Override
  public String toString() {
    return "Student{" +
            "gradYear=" + gradYear +
            ", scholarship=" + scholarship +
            ", enrollments=" + enrollments +
            '}';
  }
}

