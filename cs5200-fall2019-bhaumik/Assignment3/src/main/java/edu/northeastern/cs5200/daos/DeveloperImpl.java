package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Developer;

public class DeveloperImpl implements DeveloperDao {


  @Override
  public void createDeveloper(Developer developer) {
    int result = -1;
    Connection conn = null;
    PreparedStatement statement = null;
    final String createPerson = "Insert into person (id, first_name, last_name, username, password, email, dob)" +
            " values (?,?,?,?,?,?,?)";
    final String createDeveloper = "Insert into developer (id, developer_key) values (?,?)";

    try {
      conn = DatabaseConnection.getConnection();
      // String selectPerson = "select  * from person";
      PreparedStatement personStatement = conn.prepareStatement(createPerson);

      personStatement.setInt(1, developer.getId());
      personStatement.setString(2, developer.getFirstName());
      personStatement.setString(3, developer.getLastName());
      personStatement.setString(4, developer.getUserName());
      personStatement.setString(5, developer.getPassword());
      personStatement.setString(6, developer.getEmail());
      personStatement.setDate(7, developer.getDob());
      personStatement.executeUpdate();


      PreparedStatement devStatement = conn.prepareStatement(createDeveloper);
      devStatement.setInt(1, developer.getId());
      devStatement.setString(2, developer.getDeveloperKey());
      devStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public Collection<Developer> findAllDevelopers() {
    final String findDeveloper = "select p.id, p.first_name, p.last_name, p.username, p.password, p.email, p.dob," +
            "d.developer_key from person p join developer d on p.id = d.id";
    Collection<Developer> developers = new ArrayList<Developer>();
    Connection conn = null;
    PreparedStatement personStatement = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      personStatement = conn.prepareStatement(findDeveloper);
      result = personStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String firstName = result.getString("First_Name");
        String lastName = result.getString("Last_Name");
        String userName = result.getString("UserName");
        String password = result.getString("Password");
        String email = result.getString("Email");
        Date date = result.getDate("dob");
        String developerKey = result.getString("Developer_Key");
        Developer developerObj = new Developer(developerKey, id, firstName, lastName, userName, password,
                email, date);
        developers.add(developerObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return developers;

  }

  @Override
  public Developer findDeveloperById(int developerId) {
    final String findDeveloper = "select p.id, p.first_name, p.last_name, p.username, p.password, p.email, p.dob," +
            "d.developer_key from person p join developer d on p.id = d.id and p.id =" + developerId;
    Connection conn = null;
    PreparedStatement personStatement = null;
    Developer developerObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      personStatement = conn.prepareStatement(findDeveloper);
      result = personStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String firstName = result.getString("First_Name");
        String lastName = result.getString("Last_Name");
        String userName = result.getString("UserName");
        String password = result.getString("Password");
        String email = result.getString("Email");
        Date date = result.getDate("dob");
        String developerKey = result.getString("Developer_Key");
        developerObj = new Developer(developerKey, id, firstName, lastName, userName, password,
                email, date);
        //developers.add(developerObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return developerObj;

  }

  @Override
  public Developer findDeveloperByUsername(String username) {
    final String findDeveloper = "select p.id, p.first_name, p.last_name, p.username, p.password, p.email, p.dob," +
            "d.developer_key from person p join developer d on p.id = d.id and p.username =?";
    //System.out.println("SQL " +findDeveloper);
    Connection conn = null;
    PreparedStatement personStatement = null;
    Developer developerObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      personStatement = conn.prepareStatement(findDeveloper);
      personStatement.setString(1, username);
      result = personStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String firstName = result.getString("First_Name");
        String lastName = result.getString("Last_Name");
        String userName = result.getString("UserName");
        String password = result.getString("Password");
        String email = result.getString("Email");
        Date date = result.getDate("dob");
        String developerKey = result.getString("Developer_Key");
        developerObj = new Developer(developerKey, id, firstName, lastName, userName, password,
                email, date);
        //developers.add(developerObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return developerObj;

  }

  @Override
  public Developer findDeveloperByCredentials(String username, String password) {
    final String findDeveloper = "select p.id, p.first_name, p.last_name, p.username, p.password, p.email, p.dob," +
            "d.developer_key from person p join developer d on p.id = d.id and p.username = ? and " +
            "p.password = ?";
    //System.out.println("SQL " +findDeveloper);
    Connection conn = null;
    PreparedStatement personStatement = null;
    Developer developerObj = null;
    ResultSet result = null;
    try {
      conn = DatabaseConnection.getConnection();
      personStatement = conn.prepareStatement(findDeveloper);
      personStatement.setString(1, username);
      personStatement.setString(2, password);
      result = personStatement.executeQuery();

      while (result.next()) {
        int id = result.getInt("Id");
        String firstName = result.getString("First_Name");
        String lastName = result.getString("Last_Name");
        String userName = result.getString("UserName");
        String passWord = result.getString("Password");
        String email = result.getString("Email");
        Date date = result.getDate("dob");
        String developerKey = result.getString("Developer_Key");
        developerObj = new Developer(developerKey, id, firstName, lastName, userName, passWord,
                email, date);
        //developers.add(developerObj);

      }
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return developerObj;

  }

  @Override
  public int updateDeveloper(int developerId, Developer developer) {
    //System.out.println("ID " +developer.getId());
    final String updatePer = "update person p set p.id = ?, p.first_name = ?, " +
            "p.last_name = ?, p.username = ?, p.password = ?, p.email = ?, p.dob = ?" +
            " where p.id = ?";
    final String updateDev = "update developer d set d.id = ?, d.developer_key = ?" +
            " where d.id = ?";

    //System.out.println("SQL " +findDeveloper);
    Connection conn = null;
    PreparedStatement personStatement = null;
    PreparedStatement developerStatement = null;
    Developer developerObj = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      personStatement = conn.prepareStatement(updatePer);
      personStatement.setInt(1, developer.getId());
      personStatement.setString(2, developer.getFirstName());
      personStatement.setString(3, developer.getLastName());
      personStatement.setString(4, developer.getUserName());
      personStatement.setString(5, developer.getPassword());
      personStatement.setString(6, developer.getEmail());
      personStatement.setDate(7, developer.getDob());
      personStatement.setInt(8, developerId);

      developerStatement = conn.prepareStatement(updateDev);
      developerStatement.setInt(1, developer.getId());
      developerStatement.setString(2, developer.getDeveloperKey());
      developerStatement.setInt(3, developerId);
      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      result = personStatement.executeUpdate();
      result = developerStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;

  }


  @Override
  public int deleteDeveloper(int developerId) {
    //System.out.println("ID " +developer.getId());
    final String deleteDev = "delete from developer where id = ?";
    final String deletePer = "delete from person where id = ?";

    //System.out.println("SQL " +findDeveloper);
    Connection conn = null;
    PreparedStatement personStatement = null;
    PreparedStatement developerStatement = null;
    Developer developerObj = null;
    int result = 0;
    try {
      conn = DatabaseConnection.getConnection();
      developerStatement = conn.prepareStatement(deleteDev);
      developerStatement.setInt(1, developerId);

      personStatement = conn.prepareStatement(deletePer);
      personStatement.setInt(1, developerId);

      /*System.out.println(personStatement);
      System.out.println(developerStatement);
      */
      result = personStatement.executeUpdate();
      result = developerStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;

  }

}
