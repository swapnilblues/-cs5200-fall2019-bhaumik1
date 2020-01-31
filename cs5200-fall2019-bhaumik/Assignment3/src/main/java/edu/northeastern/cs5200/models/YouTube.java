package edu.northeastern.cs5200.models;

public class YouTube extends Widget {

  private String url;
  private boolean shareable;
  private boolean expandable;

  public YouTube(int id, String name, int width, int height, String cssClass, String cssStyle,
                 String text, int order, String url, boolean shareable, boolean expandable) {

    super(id, name, width, height, cssClass, cssStyle, text, order);
    this.url = url;
    this.shareable = shareable;
    this.expandable = expandable;

  }

  @Override
  public String getUrl() {
    return url;
  }

  @Override
  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public boolean isShareable() {
    return shareable;
  }

  @Override
  public void setShareable(boolean shareable) {
    this.shareable = shareable;
  }

  @Override
  public boolean isExpandable() {
    return expandable;
  }

  @Override
  public void setExpandable(boolean expandable) {
    this.expandable = expandable;
  }


}

