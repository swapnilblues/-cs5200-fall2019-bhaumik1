package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Faculty extends Person {

  /*@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;*/
  private String office;
  private boolean tenured;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy="faculty", cascade = CascadeType.ALL)//fetch = FetchType.EAGER, cascade = CascadeType.ALL)//, orphanRemoval = true)
  @JsonIgnore
  private Set<Course> authoredCourses = new LinkedHashSet<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "teach", cascade = CascadeType.ALL)//fetch = FetchType.EAGER, cascade = CascadeType.ALL)//, orphanRemoval = true)
  @JsonIgnore
  private Set<Section> taughtSections = new LinkedHashSet<>();


  public Faculty() {
    super();
  }

  public Faculty(String username, String password, String firstName, String lastName,
                 String office, boolean tenured) {
    super(username, password, firstName, lastName);
    this.office = office;
    this.tenured = tenured;
  }

  public Faculty(String firstName, String lastName, String office, boolean tenured) {
    super(firstName, lastName);
    this.office = office;
    this.tenured = tenured;
  }

  public String getOffice() {
    return office;
  }

  public void setOffice(String office) {
    this.office = office;
  }

  public boolean getTenured() {
    return tenured;
  }

  public void setTenured(boolean tenured) {
    this.tenured = tenured;
  }

  public Set<Course> getAuthoredCourses() {
    return authoredCourses;
  }

  public void setAuthoredCourses(Set<Course> authoredCourses) {
    this.authoredCourses = authoredCourses;
  }

  public Set<Section> getTaughtSections() {
    return taughtSections;
  }

  public void setTaughtSections(Set<Section> taughtSections) {
    this.taughtSections = taughtSections;
  }


}
