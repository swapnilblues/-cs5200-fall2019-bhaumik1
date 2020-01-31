package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

public class WebsiteImpl implements WebsiteDao {


  @Override
  public void createWebsiteForDeveloper(int developerId, Website website) {
    int result = -1;
    Connection conn = null;
    PreparedStatement statement = null;
    final String createWebsite = "insert into website (id, name, description, created, updated, " +
            "developer, visits) values (?,?,?,?,?,?,?)";

    try {
      conn = DatabaseConnection.getConnection();
      PreparedStatement websiteStatement = conn.prepareStatement(createWebsite);
      websiteStatement.setInt(1, website.getId());
      websiteStatement.setString(2, website.getName());
      websiteStatement.setString(3, website.getDescription());
      websiteStatement.setDate(4, website.getCreated());
      websiteStatement.setDate(5, website.getUpdated());
      websiteStatement.setInt(6, developerId);
      websiteStatement.setInt(7, website.getVisits());

      websiteStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Collection<Website> findAllWebsites() {
    final String findWebsite = "select * from website";
    Collection<Website> websites = new ArrayList<Website>();
    Connection conn = null;
    PreparedStatement websiteStatement = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      websiteStatement = conn.prepareStatement(findWebsite);
      result = websiteStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String name = result.getString("Name");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int visits = result.getInt("Visits");

        Website websiteObj = new Website(id, name, description, created, updated, visits);
        websites.add(websiteObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return websites;

  }

  @Override
  public Collection<Website> findWebsitesForDeveloper(int developerId) {
    final String findWebsite = "select * from website where developer = " + developerId;
    Collection<Website> websites = new ArrayList<Website>();
    Connection conn = null;
    PreparedStatement websiteStatement = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      websiteStatement = conn.prepareStatement(findWebsite);
      result = websiteStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String name = result.getString("Name");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int visits = result.getInt("Visits");
        Website websiteObj = new Website(id, name, description, created, updated, visits);
        websites.add(websiteObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return websites;
  }

  @Override
  public Website findWebsiteById(int websiteId) {
    final String findWebsite = "select * from website where id = " + websiteId;
    Connection conn = null;
    PreparedStatement websiteStatement = null;
    Website websiteObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      websiteStatement = conn.prepareStatement(findWebsite);
      result = websiteStatement.executeQuery();
      while (result.next()) {
        int id = result.getInt("Id");
        String name = result.getString("Name");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int visits = result.getInt("Visits");
        websiteObj = new Website(id, name, description, created, updated, visits);
        //developers.add(developerObj);
      }
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return websiteObj;
  }

  @Override
  public int updateWebsite(int websiteId, Website website) {
    final String updateWebsite = "update website w set w.id = ?, w.name = ?, " +
            "w.description = ?, w.created = ?, w.updated = ?, w.visits = ?" +
            " where w.id = ?";
    Connection conn = null;
    PreparedStatement websiteStatement = null;
    Website websiteObj = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      websiteStatement = conn.prepareStatement(updateWebsite);
      websiteStatement.setInt(1, website.getId());
      websiteStatement.setString(2, website.getName());
      websiteStatement.setString(3, website.getDescription());
      websiteStatement.setDate(4, website.getCreated());
      websiteStatement.setDate(5, website.getUpdated());
      websiteStatement.setInt(6, website.getVisits());
      websiteStatement.setInt(7, websiteId);
      result = websiteStatement.executeUpdate();
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;

  }

  @Override
  public int deleteWebsite(int websiteId) {
    final String deleteWebsite = "delete from website where id ="+websiteId;
    Connection conn = null;
    PreparedStatement websiteStatement = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      websiteStatement = conn.prepareStatement(deleteWebsite);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      result = websiteStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;

  }

  @Override
  public Website findWebsiteByName(String websiteName) {
    final String findWebsite = "select * from website where name = ?";
    Connection conn = null;
    PreparedStatement websiteStatement = null;
    Website websiteObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      websiteStatement = conn.prepareStatement(findWebsite);
      websiteStatement.setString(1,websiteName);
      result = websiteStatement.executeQuery();
      while (result.next()) {
        int id = result.getInt("Id");
        String name = result.getString("Name");
        String description = result.getString("Description");
        Date created = result.getDate("Created");
        Date updated = result.getDate("Updated");
        int visits = result.getInt("Visits");
        websiteObj = new Website(id, name, description, created, updated, visits);
        //developers.add(developerObj);
      }
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return websiteObj;
  }

}
