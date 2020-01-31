package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DatabaseConnection;

public class PriviledgeImpl implements PriviledgeDao {
  @Override
  public void assignWebsitePrivilege(int developerId, int websiteId, String priviledge) {
    Connection conn = null;
    PreparedStatement statement = null;
    final String createWebsitePriviledge = "insert into website_priviledge (developer, website, priviledge) " +
            "values (?,?,?)";
    try {
      conn = DatabaseConnection.getConnection();
      PreparedStatement webPriviledgeStatement = conn.prepareStatement(createWebsitePriviledge);
      webPriviledgeStatement.setInt(1, developerId);
      webPriviledgeStatement.setInt(2, websiteId);
      webPriviledgeStatement.setString(3, priviledge);
      webPriviledgeStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
    Connection conn = null;
    PreparedStatement statement = null;
    final String createPagePriviledge = "insert into page_priviledge (developer, page, priviledge) " +
            "values (?,?,?)";
    try {
      conn = DatabaseConnection.getConnection();
      PreparedStatement pagePriviledgeStatement = conn.prepareStatement(createPagePriviledge);
      pagePriviledgeStatement.setInt(1, developerId);
      pagePriviledgeStatement.setInt(2, pageId);
      pagePriviledgeStatement.setString(3, priviledge);
      pagePriviledgeStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }


  @Override
  public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
    final String deleteWebsitePriviledge = "delete from website_priviledge where developer = ? and " +
            "website = ? and priviledge = ?";
    Connection conn = null;
    PreparedStatement websitePriviledgeStatement = null;
    try {
      conn = DatabaseConnection.getConnection();
      websitePriviledgeStatement = conn.prepareStatement(deleteWebsitePriviledge);
      websitePriviledgeStatement.setInt(1, developerId);
      websitePriviledgeStatement.setInt(2, websiteId);
      websitePriviledgeStatement.setString(3, priviledge);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      websitePriviledgeStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
    final String deletePagePriviledge = "delete from page_priviledge where developer = ? and page = ? and priviledge = ?";
    Connection conn = null;
    PreparedStatement pagePriviledgeStatement = null;
    try {
      conn = DatabaseConnection.getConnection();
      pagePriviledgeStatement = conn.prepareStatement(deletePagePriviledge);
      pagePriviledgeStatement.setInt(1, developerId);
      pagePriviledgeStatement.setInt(2, pageId);
      pagePriviledgeStatement.setString(3, priviledge);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      pagePriviledgeStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
