package edu.northeastern.cs5200.models;

import java.sql.*;
import java.util.Collection;

public class Person {
  private int id;
  private String firstName;
  private String lastName;
  private String userName;
  private String password;
  private String email;
  private Date dob;
  private Collection<Phone> phone;
  private Collection<Address> address;


  public Person(int id, String firstName, String lastName, String userName, String password, String email,
                Date dob, Collection<Phone> phone, Collection<Address> address) {
    //System.out.println("ID:" +id);
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.password = password;
    this.email = email;
    this.dob = dob;
    this.phone = phone;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setDob(Date dob) {
    this.dob = dob;
  }

  public Collection<Phone> getPhone() {
    return phone;
  }

  public void setPhone(Collection<Phone> phone) {
    this.phone = phone;
  }

  public Collection<Address> getAddress() {
    return address;
  }

  public void setAddress(Collection<Address> address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public Date getDob() {
    return dob;
  }

  @Override
  public String toString() {
    return id + " , "
    +firstName + " , "
    +lastName + " , "
    +userName + " , "
    +password + " , "
    +email + " , "
    +dob + ", ";
  }
}
