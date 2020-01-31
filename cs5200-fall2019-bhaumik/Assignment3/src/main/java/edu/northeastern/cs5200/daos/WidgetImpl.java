package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Dtype;
import edu.northeastern.cs5200.models.Widget;

public class WidgetImpl implements WidgetDao {

  @Override
  public void createWidgetForPage(int pageId, Widget widget) {
    Connection conn = null;
    PreparedStatement statement = null;
    final String createWidgetYouTube = "insert into widget (id, name, width, height, css_class, css_style," +
            "text, order_number, dtype, url, shareble, expandable, page) values"
            + "(?,?,?,?,?,?,?,?,?,?,?,?,?)";

    final String createWidgetHeading = "insert into widget (id, name, width, height, css_class, css_style," +
            "text, order_number, dtype, size, page) values"
            + "(?,?,?,?,?,?,?,?,?,?,?)";

    final String createWidgetImage = "insert into widget (id, name, width, height, css_class, css_style," +
            "text, order_number, dtype, src, page) values"
            + "(?,?,?,?,?,?,?,?,?,?,?)";

    final String createWidgetHtml = "insert into widget (id, name, width, height, css_class, css_style," +
            "text, order_number, dtype, html, page) values"
            + "(?,?,?,?,?,?,?,?,?,?,?)";
    try {
      conn = DatabaseConnection.getConnection();

      if (widget.getDtype() == Dtype.YouTube) {
        PreparedStatement youTubeStatement = conn.prepareStatement(createWidgetYouTube);
        youTubeStatement.setInt(1, widget.getId());
        youTubeStatement.setString(2, widget.getName());
        youTubeStatement.setInt(3, widget.getWidth());
        youTubeStatement.setInt(4, widget.getHeight());
        youTubeStatement.setString(5, widget.getCssClass());
        youTubeStatement.setString(6, widget.getCssStyle());
        youTubeStatement.setString(7, widget.getText());
        youTubeStatement.setInt(8, widget.getOrder());
        youTubeStatement.setString(9, "YouTube");
        youTubeStatement.setString(10, widget.getUrl());
        youTubeStatement.setBoolean(11, widget.isShareable());
        youTubeStatement.setBoolean(12, widget.isExpandable());
        youTubeStatement.setInt(13, pageId);
        youTubeStatement.executeUpdate();
        DatabaseConnection.closeConnection();

      }else if (widget.getDtype() == Dtype.Heading) {
        PreparedStatement headingStatement = conn.prepareStatement(createWidgetHeading);
        headingStatement.setInt(1, widget.getId());
        headingStatement.setString(2, widget.getName());
        headingStatement.setInt(3, widget.getWidth());
        headingStatement.setInt(4, widget.getHeight());
        headingStatement.setString(5, widget.getCssClass());
        headingStatement.setString(6, widget.getCssStyle());
        headingStatement.setString(7, widget.getText());
        headingStatement.setInt(8, widget.getOrder());
        headingStatement.setString(9, "Heading");
        headingStatement.setInt(10, widget.getSize());
        headingStatement.setInt(11, pageId);
        headingStatement.executeUpdate();
        DatabaseConnection.closeConnection();
      }else if (widget.getDtype() == Dtype.Image) {
        PreparedStatement imageStatement = conn.prepareStatement(createWidgetImage);
        imageStatement.setInt(1, widget.getId());
        imageStatement.setString(2, widget.getName());
        imageStatement.setInt(3, widget.getWidth());
        imageStatement.setInt(4, widget.getHeight());
        imageStatement.setString(5, widget.getCssClass());
        imageStatement.setString(6, widget.getCssStyle());
        imageStatement.setString(7, widget.getText());
        imageStatement.setInt(8, widget.getOrder());
        imageStatement.setString(9, "Image");
        imageStatement.setString(10, widget.getSrc());
        imageStatement.setInt(11, pageId);
        imageStatement.executeUpdate();
        DatabaseConnection.closeConnection();
      }else if (widget.getDtype() == Dtype.Html) {
        PreparedStatement htmlStatement = conn.prepareStatement(createWidgetHtml);
        htmlStatement.setInt(1, widget.getId());
        htmlStatement.setString(2, widget.getName());
        htmlStatement.setInt(3, widget.getWidth());
        htmlStatement.setInt(4, widget.getHeight());
        htmlStatement.setString(5, widget.getCssClass());
        htmlStatement.setString(6, widget.getCssStyle());
        htmlStatement.setString(7, widget.getText());
        htmlStatement.setInt(8, widget.getOrder());
        htmlStatement.setString(9, "Html");
        htmlStatement.setString(10, widget.getHtml());
        htmlStatement.setInt(11, pageId);
        htmlStatement.executeUpdate();
        DatabaseConnection.closeConnection();
      }

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Collection<Widget> findAllWidgets() {
    final String findWidget = "select * from widget";
    Collection<Widget> widgets = new ArrayList<Widget>();
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    ResultSet result = null;
    Dtype dtype = null;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(findWidget);
      result = widgetStatement.executeQuery();

      while (result.next()) {

        int id = result.getInt("Id");
        String name = result.getString("Name");
        int width = result.getInt("Width");
        int height = result.getInt("Height");
        String cssStyle = result.getString("css_Style");
        String cssClass= result.getString("css_Class");
        String text = result.getString("Text");
        int order = result.getInt("order_number");
        int size = result.getInt("order_number");
        String html = result.getString("Text");
        String src = result.getString("Src");
        String url = result.getString("URL");
        boolean shareable = result.getBoolean("shareble");
        boolean expandable = result.getBoolean("expandable");
        if(result.getString("dtype").equalsIgnoreCase("YouTube")) {
         dtype = edu.northeastern.cs5200.models.Dtype.YouTube;
        }else if(result.getString("dtype").equalsIgnoreCase("Heading")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Heading;
        }else if(result.getString("dtype").equalsIgnoreCase("Html")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Html;
        }
        else if(result.getString("dtype").equalsIgnoreCase("Image")) {
         dtype = edu.northeastern.cs5200.models.Dtype.Image;
        }
          Widget widgetObj = new Widget(id, name, width, height, cssStyle, cssClass, text,order,
                  size,html,src,url,shareable,expandable,dtype);
        widgets.add(widgetObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return widgets;

  }

  @Override
  public Widget findWidgetById(int widgetId) {
    final String findWidget = "select * from widget where id ="+widgetId;
    //Collection<Widget> widgets = new ArrayList<Widget>();
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    ResultSet result = null;
    Dtype dtype = null;
    Widget widgetObj = null;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(findWidget);
      result = widgetStatement.executeQuery();

      while (result.next()) {

        int id = result.getInt("Id");
        String name = result.getString("Name");
        int width = result.getInt("Width");
        int height = result.getInt("Height");
        String cssStyle = result.getString("css_Style");
        String cssClass= result.getString("css_Class");
        String text = result.getString("Text");
        int order = result.getInt("order_number");
        int size = result.getInt("order_number");
        String html = result.getString("Text");
        String src = result.getString("Src");
        String url = result.getString("URL");
        boolean shareable = result.getBoolean("shareble");
        boolean expandable = result.getBoolean("expandable");
        if(result.getString("dtype").equalsIgnoreCase("YouTube")) {
          dtype = edu.northeastern.cs5200.models.Dtype.YouTube;
        }else if(result.getString("dtype").equalsIgnoreCase("Heading")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Heading;
        }else if(result.getString("dtype").equalsIgnoreCase("Html")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Html;
        }
        else if(result.getString("dtype").equalsIgnoreCase("Image")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Image;
        }
        widgetObj = new Widget(id, name, width, height, cssStyle, cssClass, text,order,
                size,html,src,url,shareable,expandable,dtype);
        //widgets.add(widgetObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return widgetObj;

  }

  @Override
  public Collection<Widget> findWidgetsForPage(int pageId) {
    final String findWidget = "select * from widget where page ="+pageId;
    Collection<Widget> widgets = new ArrayList<Widget>();
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    ResultSet result = null;
    Dtype dtype = null;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(findWidget);
      result = widgetStatement.executeQuery();

      while (result.next()) {

        int id = result.getInt("Id");
        String name = result.getString("Name");
        int width = result.getInt("Width");
        int height = result.getInt("Height");
        String cssStyle = result.getString("css_Style");
        String cssClass= result.getString("css_Class");
        String text = result.getString("Text");
        int order = result.getInt("order_number");
        int size = result.getInt("order_number");
        String html = result.getString("Text");
        String src = result.getString("Src");
        String url = result.getString("URL");
        boolean shareable = result.getBoolean("shareble");
        boolean expandable = result.getBoolean("expandable");
        if(result.getString("dtype").equalsIgnoreCase("YouTube")) {
          dtype = edu.northeastern.cs5200.models.Dtype.YouTube;
        }else if(result.getString("dtype").equalsIgnoreCase("Heading")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Heading;
        }else if(result.getString("dtype").equalsIgnoreCase("Html")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Html;
        }
        else if(result.getString("dtype").equalsIgnoreCase("Image")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Image;
        }
        Widget widgetObj = new Widget(id, name, width, height, cssStyle, cssClass, text,order,
                size,html,src,url,shareable,expandable,dtype);
        widgets.add(widgetObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return widgets;

  }

  @Override
  public int updateWidget(int widgetId, Widget widget) {
    final String updateWidget = "update widget w set w.id = ?, w.name = ?, w.width = ?, w.height = ?," +
            "w.css_class = ?, w.css_style = ?, w.text = ?, w.order_number = ?, w.dtype = ?, w.size = ?," +
            "w.html = ?, w.url = ?, w.shareble = ?, w.expandable = ?, w.src = ? where w.id" +
            "= ?";
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    Widget widgetObj = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(updateWidget);
      widgetStatement.setInt(1, widget.getId());
      widgetStatement.setString(2, widget.getName());
      widgetStatement.setInt(3, widget.getWidth());
      widgetStatement.setInt(4, widget.getHeight());
      widgetStatement.setString(5, widget.getCssClass());
      widgetStatement.setString(6, widget.getCssStyle());
      widgetStatement.setString(7, widget.getText());
      widgetStatement.setInt(8, widget.getOrder());
      if(widget.getDtype() == Dtype.Heading) {
        widgetStatement.setString(9, "Heading");
      }else if(widget.getDtype() == Dtype.YouTube) {
        widgetStatement.setString(9, "YouTube");
      }else if(widget.getDtype() == Dtype.Image) {
        widgetStatement.setString(9, "Image");
      }else if(widget.getDtype() == Dtype.Html) {
        widgetStatement.setString(9, "Html");
      }
      widgetStatement.setInt(10, widget.getSize());
      widgetStatement.setString(11, widget.getHtml());
      widgetStatement.setString(12, widget.getUrl());
      widgetStatement.setBoolean(13, widget.isShareable());
      widgetStatement.setBoolean(14, widget.isExpandable());
      widgetStatement.setString(15, widget.getSrc());
      widgetStatement.setInt(16, widgetId);
      result = widgetStatement.executeUpdate();
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int deleteWidget(int widgetId) {
    final String deleteWidget = "delete from widget where id ="+widgetId;
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(deleteWidget);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      result = widgetStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Widget findWidgetByName(String widgetName) {
    final String findWidget = "select * from widget where name =?";
    //Collection<Widget> widgets = new ArrayList<Widget>();
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    ResultSet result = null;
    Dtype dtype = null;
    Widget widgetObj = null;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(findWidget);
      widgetStatement.setString(1, widgetName);
      result = widgetStatement.executeQuery();

      while (result.next()) {

        int id = result.getInt("Id");
        String name = result.getString("Name");
        int width = result.getInt("Width");
        int height = result.getInt("Height");
        String cssStyle = result.getString("css_Style");
        String cssClass= result.getString("css_Class");
        String text = result.getString("Text");
        int order = result.getInt("order_number");
        int size = result.getInt("order_number");
        String html = result.getString("Text");
        String src = result.getString("Src");
        String url = result.getString("URL");
        boolean shareable = result.getBoolean("shareble");
        boolean expandable = result.getBoolean("expandable");
        if(result.getString("dtype").equalsIgnoreCase("YouTube")) {
          dtype = edu.northeastern.cs5200.models.Dtype.YouTube;
        }else if(result.getString("dtype").equalsIgnoreCase("Heading")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Heading;
        }else if(result.getString("dtype").equalsIgnoreCase("Html")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Html;
        }
        else if(result.getString("dtype").equalsIgnoreCase("Image")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Image;
        }
        widgetObj = new Widget(id, name, width, height, cssStyle, cssClass, text,order,
                size,html,src,url,shareable,expandable,dtype);
        //widgets.add(widgetObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return widgetObj;
  }

  @Override
  public Widget findWidgetByOrder(int orderNumber) {
    final String findWidget = "select * from widget where order_number =" + orderNumber;
    //Collection<Widget> widgets = new ArrayList<Widget>();
    Connection conn = null;
    PreparedStatement widgetStatement = null;
    ResultSet result = null;
    Dtype dtype = null;
    Widget widgetObj = null;
    try {
      conn = DatabaseConnection.getConnection();
      widgetStatement = conn.prepareStatement(findWidget);
      result = widgetStatement.executeQuery();

      while (result.next()) {

        int id = result.getInt("Id");
        String name = result.getString("Name");
        int width = result.getInt("Width");
        int height = result.getInt("Height");
        String cssStyle = result.getString("css_Style");
        String cssClass= result.getString("css_Class");
        String text = result.getString("Text");
        int order = result.getInt("order_number");
        int size = result.getInt("order_number");
        String html = result.getString("Text");
        String src = result.getString("Src");
        String url = result.getString("URL");
        boolean shareable = result.getBoolean("shareble");
        boolean expandable = result.getBoolean("expandable");
        if(result.getString("dtype").equalsIgnoreCase("YouTube")) {
          dtype = edu.northeastern.cs5200.models.Dtype.YouTube;
        }else if(result.getString("dtype").equalsIgnoreCase("Heading")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Heading;
        }else if(result.getString("dtype").equalsIgnoreCase("Html")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Html;
        }
        else if(result.getString("dtype").equalsIgnoreCase("Image")) {
          dtype = edu.northeastern.cs5200.models.Dtype.Image;
        }
        widgetObj = new Widget(id, name, width, height, cssStyle, cssClass, text,order,
                size,html,src,url,shareable,expandable,dtype);
        //widgets.add(widgetObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return widgetObj;
  }

}
