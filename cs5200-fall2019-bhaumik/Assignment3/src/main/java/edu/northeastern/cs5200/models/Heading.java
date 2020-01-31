package edu.northeastern.cs5200.models;

public class Heading extends Widget {

  private int size;

  public Heading(int id, String name, int width, int height, String cssClass, String cssStyle,
               String text, int order, int size) {
    super(id, name, width, height, cssClass, cssStyle, text, order);
    this.size = size;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void setSize(int size) {
    this.size = size;
  }
}
