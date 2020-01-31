package edu.northeastern.cs5200.models;

public class PagePriviledge {
  private int id;
  private String priviledge;

  public PagePriviledge(String priviledge) {
    this.priviledge = priviledge;
  }

  public String getPriviledge() {
    return priviledge;
  }

  public void setPriviledge(String priviledge) {
    this.priviledge = priviledge;
  }
}


