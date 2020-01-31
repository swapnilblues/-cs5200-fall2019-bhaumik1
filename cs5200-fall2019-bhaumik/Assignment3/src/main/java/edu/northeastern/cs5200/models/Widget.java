package edu.northeastern.cs5200.models;

public class Widget {

  private int id;
  private String name;
  private int width;


  private int height;
  private String cssClass;
  private String cssStyle;
  private String text;
  private int order;
  private Dtype dtype;
  private String url;
  private boolean shareable;
  private boolean expandable;
  private int size;
  private String html;
  private String src;

  public Widget(int id, String name, int width, int height, String cssStyle, String cssClass,
                String text, int order) {
    this.id = id;
    this.name = name;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.cssStyle = cssStyle;
    this.text = text;
    this.order = order;
  }

  public Widget(int id, String name, int width, int height, String cssStyle, String cssClass,
                String text, int order, int size, String html, String src, String url,
                boolean shareable, boolean expandable,Dtype dtype) {
    this.id = id;
    this.name = name;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.cssStyle = cssStyle;
    this.text = text;
    this.order = order;
    this.dtype = dtype;
    this.shareable = shareable;
    this.expandable = expandable;
    this.size = size;
    this.html = html;
    this.src = src;
    this.url = url;
  }

  public Widget() {

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

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getCssStyle() {
    return cssStyle;
  }

  public void setCssStyle(String cssStyle) {
    this.cssStyle = cssStyle;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public Dtype getDtype() {
    return dtype;
  }

  public void setDtype(Dtype dtype) {
    this.dtype = dtype;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isShareable() {
    return shareable;
  }

  public void setShareable(boolean shareable) {
    this.shareable = shareable;
  }

  public boolean isExpandable() {
    return expandable;
  }

  public void setExpandable(boolean expandable) {
    this.expandable = expandable;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  @Override
  public String toString() {
    return id + " , " +
            name + " , " +
            width + " , " +
            height + " , " +
            cssClass + " , " +
            cssStyle + " , " +
            text + " , " +
            order + " , " +
            dtype + " , " +
            size + " , " +
            html + " , " +
            url + " , " +
            shareable + " , " +
            expandable + " , " +
            src + " \n ";
  }
}
