package edu.northeastern.cs5200.models;

public class Html extends Widget {

  private String html;

  public Html(int id, String name, int width, int height, String cssClass, String cssStyle,
                 String text, int order, String html) {
    super(id, name, width, height, cssClass, cssStyle, text, order);
    this.html = html;
  }

  @Override
  public String getHtml() {
    return html;
  }

  @Override
  public void setHtml(String html) {
    this.html = html;
  }
}
