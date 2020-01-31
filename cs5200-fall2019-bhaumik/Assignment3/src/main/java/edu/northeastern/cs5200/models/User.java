package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class User extends Person{
  private int id;
  private String userAgreement;

  public User(String userAgreement, int id, String firstName, String lastName, String userName,
              String password, String email, Date dob) {
    super(id, firstName, lastName, userName, password, email, dob,
            null, null);
    this.id = id;
    this.userAgreement = userAgreement;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public String getUserAgreement() {
    return userAgreement;
  }

  public void setUserAgreement(String userAgreement) {
    this.userAgreement = userAgreement;
  }
}
