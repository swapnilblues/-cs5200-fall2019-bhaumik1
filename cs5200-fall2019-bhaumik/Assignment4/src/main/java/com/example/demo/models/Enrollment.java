package com.example.demo.models;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {

  @EmbeddedId
  private CompositeId id;
  @ManyToOne
  @JoinColumn(name = "student", insertable = false, updatable = false)
  private Student student;

  @ManyToOne
  @JoinColumn(name = "section", insertable = false, updatable = false)
  private Section section;
  private Integer grade;
  private String feedback;

  public Enrollment() {
  }

  public Enrollment(Student student, Section section) {
    this.student = student;
    this.section = section;
    this.id = new CompositeId(section.getId(), student.getId());
  }

  public CompositeId getId() {
    return id;
  }

  public void setId(CompositeId id) {
    this.id = id;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public Integer getGrade() {
    return grade;
  }

  public void setGrade(Integer grade) {
    this.grade = grade;
  }

  public String getFeedback() {
    return feedback;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  @Override
  public String toString() {
    return "Enrollment{" +
            "id=" + id +
            ", student=" + student +
            ", section=" + section +
            ", grade=" + grade +
            ", feedback='" + feedback + '\'' +
            '}';
  }
}