package edu.northeastern.cs5200.models;

public class Image extends Widget {

  private String src;

  public Image(int id, String name, int width, int height, String cssClass, String cssStyle,
               String text, int order, String src) {
    super(id, name, width, height, cssClass, cssStyle, text, order);
    this.src = src;
  }

  @Override
  public String getSrc() {
    return src;
  }

  @Override
  public void setSrc(String src) {
    this.src = src;
  }
}
