package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.LinkedHashSet;
import java.util.List;
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
public class Course {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private Integer id;
  private String title;

  @ManyToOne()
  private Faculty faculty;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)//fetch = FetchType.EAGER, cascade = CascadeType.ALL)//, orphanRemoval = true)
  @JsonIgnore
  private Set<Section> listOfSections = new LinkedHashSet<>();

  public Course() {
  }

  public Course(String title) {
    this.title = title;
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

  public Faculty getAuthor() {
    return faculty;
  }

  public void setAuthor(Faculty faculty) {
    this.faculty = faculty;
  }

  public Set<Section> getListOfSections() {
    return listOfSections;
  }

  public void setListOfSections(Set<Section> listOfSections) {
    this.listOfSections = listOfSections;
  }

  @Override
  public String toString() {
    return "Course{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", faculty=" + faculty +
            ", listOfSections=" + listOfSections +
            '}';
  }
}
