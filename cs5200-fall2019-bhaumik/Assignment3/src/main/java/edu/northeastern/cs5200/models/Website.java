package edu.northeastern.cs5200.models;

import java.sql.*;
import java.util.Collection;


public class Website {

  private int id;
  private String name;
  private String description;
  private Date created;
  private Date updated;
  private int visits;
  private Collection<Page> pages;
  private Collection<WebsitePriviledge> websitePriviledges;
  private Collection<WebsiteRole> websiteRoles;
  private Collection<Website> websites;
  private int developer;

  public Website(int id, String name, String description, Date created, Date updated, int visits) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.created = created;
    this.updated = updated;
    this.visits = visits;
  }

  public int getDeveloper() {
    return developer;
  }

  public void setDeveloper(int developer) {
    this.developer = developer;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public int getVisits() {
    return visits;
  }

  public void setVisits(int visits) {
    this.visits = visits;
  }

  public Collection<Page> getPages() {
    return pages;
  }

  public void setPages(Collection<Page> pages) {
    this.pages = pages;
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

  public Collection<Website> getWebsites() {
    return websites;
  }

  public void setWebsites(Collection<Website> websites) {
    this.websites = websites;
  }

  @Override
  public String toString() {
    return id + " , " + name + " , "+ description + " , "+ created + " , "+ updated + " , "
            + visits +  " \n ";

  }
}
