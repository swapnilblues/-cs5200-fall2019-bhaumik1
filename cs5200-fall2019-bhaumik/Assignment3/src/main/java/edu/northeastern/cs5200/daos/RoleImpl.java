package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.northeastern.cs5200.DatabaseConnection;

public class RoleImpl implements RoleDao {

  @Override
  public void assignWebsiteRole(int developerId, int websiteId, String role) {
    Connection conn = null;
    PreparedStatement statement = null;
    final String createWebsiteRole = "insert into website_role (developer, website, role) " +
            "values (?,?,?)";
    try {
      conn = DatabaseConnection.getConnection();
      PreparedStatement webRoleStatement = conn.prepareStatement(createWebsiteRole);
      webRoleStatement.setInt(1, developerId);
      webRoleStatement.setInt(2, websiteId);
      webRoleStatement.setString(3, role);
      webRoleStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void assignPageRole(int developerId, int pageId, String role) {

    Connection conn = null;
    PreparedStatement statement = null;
    final String createPageRole = "insert into page_role (developer, page, role) " +
            "values (?,?,?)";
    try {
      conn = DatabaseConnection.getConnection();
      PreparedStatement webRoleStatement = conn.prepareStatement(createPageRole);
      webRoleStatement.setInt(1, developerId);
      webRoleStatement.setInt(2, pageId);
      webRoleStatement.setString(3, role);
      webRoleStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void deleteWebsiteRole(int developerId, int websiteId, String role) {
    final String deleteWebsiteRole = "delete from website_role where developer = ? and website = ? and role = ?";
    Connection conn = null;
    PreparedStatement websiteRoleStatement = null;
    try {
      conn = DatabaseConnection.getConnection();
      websiteRoleStatement = conn.prepareStatement(deleteWebsiteRole);
      websiteRoleStatement.setInt(1, developerId);
      websiteRoleStatement.setInt(2, websiteId);
      websiteRoleStatement.setString(3, role);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      websiteRoleStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deletePageRole(int developerId, int pageId, String role) {
    final String deletePageRole = "delete from page_role where developer = ? and page = ? and role = ?";
    Connection conn = null;
    PreparedStatement pageRoleStatement = null;
    try {
      conn = DatabaseConnection.getConnection();
      pageRoleStatement = conn.prepareStatement(deletePageRole);
      pageRoleStatement.setInt(1, developerId);
      pageRoleStatement.setInt(2, pageId);
      pageRoleStatement.setString(3, role);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      pageRoleStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String findPageRoleForDeveloper(int developerId, int pageId) {
    final String findPageRole = "select * from page_role where developer = ? and page = ?";
    Connection conn = null;
    PreparedStatement pageRoleStatement = null;
    ResultSet result = null;
    String role = null;
    try {
      conn = DatabaseConnection.getConnection();
      pageRoleStatement = conn.prepareStatement(findPageRole);
      pageRoleStatement.setInt(1,developerId);
      pageRoleStatement.setInt(2,pageId);
      result = pageRoleStatement.executeQuery();
      while (result.next()) {
        role = result.getString("role");
      }
      DatabaseConnection.closeConnection();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return role;
  }

}

