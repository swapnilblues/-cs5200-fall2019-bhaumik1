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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Section {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String title;
  private Integer seats;


  @ManyToOne
  private Faculty teach;

  @ManyToOne
  private Course course;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @OneToMany(mappedBy="section", cascade = CascadeType.ALL)//, fetch = FetchType.EAGER, cascade = CascadeType.ALL)//, orphanRemoval = true)
  @JsonIgnore
  private Set<Enrollment> enrollments;

  public Section(String title, Integer seats) {
    this.title = title;
    this.seats = seats;
  }



  public Section() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getSeats() {
    return seats;
  }

  public void setSeats(Integer seats) {
    this.seats = seats;
  }

  public Faculty getTeach() {
    return teach;
  }

  public void setTeach(Faculty teach) {
    this.teach = teach;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Set<Enrollment> getEnrollments() {
    return enrollments;
  }

  public void setEnrollments(Set<Enrollment> enrollments) {
    this.enrollments = enrollments;
  }
}
