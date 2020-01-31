package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Developer extends Person {
  private int id;
  private String developerKey;
  private Collection<WebsitePriviledge> websitePriviledges;
  private Collection<WebsiteRole> websiteRoles;
  private Collection<PagePriviledge> pagePriviledges;
  private Collection<PageRole> pageRoles;

  /*public Developer(String firstName, String lastName, String userName, String password,
                   String email, Date dob, Collection<Phone> phone, Collection<Address> address,
                   String developerKey) {
    super(firstName, lastName, userName, password, email, dob, phone, address);
    this.developerKey = developerKey;
  }*/


  public Developer(String developerKey, int id, String firstName, String lastName) {
    super(id,firstName,lastName,"", null, null,null
            ,null, null);
    this.developerKey = developerKey;
  }

  public Developer(String developerKey, int id, String firstName, String lastName, String userName,
                   String password, String email, Date dob) {
    super(id,firstName,lastName,userName, password, email,dob
            ,null, null);
    this.developerKey = developerKey;
  }

  public Developer(String developerKey, int id, String firstName, String lastName,String userName,
                   String password, String email, Date dob, Collection<Address> addresses,
                   Collection<Phone> phones) {
    super(id,firstName,lastName,userName, password, email,dob,phones,addresses);
    this.developerKey = developerKey;
  }

  @Override
  public int getId() {
    return super.getId();
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public String getDeveloperKey() {
    return developerKey;
  }

  public void setDeveloperKey(String developerKey) {
    this.developerKey = developerKey;
  }

  public Collection<WebsitePriviledge> getWebsitePriviledges() {
    return websitePriviledges;
  }

  public void setWebsitePriviledges(Collection<WebsitePriviledge> websitePriviledges) {
    this.websitePriviledges = websitePriviledges;
  }

  public Collection<WebsiteRole> getWebsiteRoles() {
    return websiteRoles;
  }

  public void setWebsiteRoles(Collection<WebsiteRole> websiteRoles) {
    this.websiteRoles = websiteRoles;
  }

  public Collection<PagePriviledge> getPagePriviledges() {
    return pagePriviledges;
  }

  public void setPagePriviledges(Collection<PagePriviledge> pagePriviledges) {
    this.pagePriviledges = pagePriviledges;
  }

  public Collection<PageRole> getPageRoles() {
    return pageRoles;
  }

  public void setPageRoles(Collection<PageRole> pageRoles) {
    this.pageRoles = pageRoles;
  }

  @Override
  public String toString() {
    return super.toString() +developerKey +"\n" ;
  }


}
