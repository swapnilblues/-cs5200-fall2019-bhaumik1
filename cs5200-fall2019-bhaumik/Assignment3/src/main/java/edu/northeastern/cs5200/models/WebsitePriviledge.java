package edu.northeastern.cs5200.models;

public class WebsitePriviledge {
  private int id;
  private String priviledge;

  public WebsitePriviledge(String priviledge) {
    this.priviledge = priviledge;
  }

  public String getPriviledge() {
    return priviledge;
  }

  public void setPriviledge(String priviledge) {
    this.priviledge = priviledge;
  }
}
