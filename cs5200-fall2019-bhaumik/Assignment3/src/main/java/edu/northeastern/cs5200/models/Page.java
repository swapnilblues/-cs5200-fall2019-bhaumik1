package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.Collection;

public class Page {

  private int id;
  private String title;
  private String description;
  private Date created;
  private Date updated;
  private int views;
  private Collection<WebsitePriviledge> websitePriviledges;
  private Collection<WebsiteRole> websiteRoles;

  private Collection<Widget> widgets;



  public Page(int id, String title, String description, Date created, Date updated, int views) {

    this.id = id;
    this.title = title;
    this.description = description;
    this.created = created;
    this.updated = updated;
    this.views = views;
  }

  public Page() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescriptiion() {
    return description;
  }

  public void setDescriptiion(String description) {
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

  public int getViews() {
    return views;
  }

  public void setViews(int visits) {
    this.views = views;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Collection<Widget> getWidgets() {
    return widgets;
  }

  public void setWidgets(Collection<Widget> widgets) {
    this.widgets = widgets;
  }


  @Override
  public String toString() {
    return id + " , " + title + " , "+ description + " , "+ created + " , "+ updated + " , "
            + views +  " \n ";

  }
}
