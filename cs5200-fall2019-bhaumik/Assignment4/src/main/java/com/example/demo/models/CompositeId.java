package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;

public class CompositeId implements Serializable {

  @Column(name = "section")
  private Integer section;

  @Column(name = "student")
  private Integer student;

  public CompositeId() {
  }

  public CompositeId(Integer section, Integer student) {
    this.section = section;
    this.student = student;
  }

  public Integer getSection() {
    return section;
  }

  public void setSection(Integer section) {
    this.section = section;
  }

  public Integer getStudent() {
    return student;
  }

  public void setStudent(Integer student) {
    this.student = student;
  }
}

