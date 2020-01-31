package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Page;

public class PageImpl implements PageDao{

  @Override
  public void createPageForWebsite(int websiteId, Page page) {
    Connection conn = null;
    PreparedStatement statement = null;
    final String createPage = "insert into page (id, title, description, created, updated, " +
            "views, website) values (?,?,?,?,?,?,?)";
    

    try {
      conn = DatabaseConnection.getConnection();
      PreparedStatement pageStatement = conn.prepareStatement(createPage);
      pageStatement.setInt(1, page.getId());
      pageStatement.setString(2, page.getTitle());
      pageStatement.setString(3, page.getDescription());
      pageStatement.setDate(4, page.getCreated());
      pageStatement.setDate(5, page.getUpdated());
      pageStatement.setInt(6, page.getViews());
      pageStatement.setInt(7, websiteId);


      pageStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  @Override
  public Collection<Page> findAllPages() {
    final String findPage = "select * from page";
    Collection<Page> pages = new ArrayList<Page>();
    Connection conn = null;
    PreparedStatement pageStatement = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      pageStatement = conn.prepareStatement(findPage);
      result = pageStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String title = result.getString("Title");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int views = result.getInt("Views");

        Page websiteObj = new Page(id, title, description, created, updated, views);
        pages.add(websiteObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pages;

  }



  @Override
  public Page findPageById(int pageId) {
    final String findPage = "select * from page where id = " + pageId;
    Connection conn = null;
    PreparedStatement pageStatement = null;
    Page pageObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      pageStatement = conn.prepareStatement(findPage);
      result = pageStatement.executeQuery();
      while (result.next()) {
        int id = result.getInt("Id");
        String title = result.getString("Title");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int views = result.getInt("Views");
        pageObj = new Page(id, title, description, created, updated, views);
        //developers.add(developerObj);
      }
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return pageObj;
  }


  @Override
  public Collection<Page> findPagesForWebsite(int websiteId) {
    final String findPage = "select * from page where website = " + websiteId;
    Collection<Page> pages = new ArrayList<Page>();
    Connection conn = null;
    PreparedStatement pageStatement = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      pageStatement = conn.prepareStatement(findPage);
      result = pageStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String title = result.getString("Title");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int views = result.getInt("Views");
        Page pageObj = new Page(id, title, description, created, updated, views);
        pages.add(pageObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return pages;
  }


  @Override
  public int updatePage(int pageId, Page page) {
    final String updatePage = "update page p set p.id = ?, p.title = ?, " +
            "p.description = ?, p.created = ?, p.updated = ?, p.views = ?" +
            " where p.id = ?";
    Connection conn = null;
    PreparedStatement pageStatement = null;
    Page pageObj = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      pageStatement = conn.prepareStatement(updatePage);
      pageStatement.setInt(1, page.getId());
      pageStatement.setString(2, page.getTitle());
      pageStatement.setString(3, page.getDescription());
      pageStatement.setDate(4, page.getCreated());
      pageStatement.setDate(5, page.getUpdated());
      pageStatement.setInt(6, page.getViews());
      pageStatement.setInt(7, pageId);
      result = pageStatement.executeUpdate();
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;

  }

  @Override
  public int deletePage(int pageId) {
    final String deletePage = "delete from page where id ="+pageId;
    Connection conn = null;
    PreparedStatement pageStatement = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      pageStatement = conn.prepareStatement(deletePage);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      result = pageStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Page findPageByTitle(String pageTitle) {
    final String findPage = "select * from page where title = ?";
    Connection conn = null;
    PreparedStatement pageStatement = null;
    Page pageObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      pageStatement = conn.prepareStatement(findPage);
      pageStatement.setString(1, pageTitle);
      result = pageStatement.executeQuery();
      while (result.next()) {
        int id = result.getInt("Id");
        String title = result.getString("Title");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int views = result.getInt("Views");
        pageObj = new Page(id, title, description, created, updated, views);
        //developers.add(developerObj);
      }
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return pageObj;
  }

}
