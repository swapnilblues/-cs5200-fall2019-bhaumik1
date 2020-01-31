package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.User;


public class UserImpl implements UserDao {
  @Override
  public void createUser(User user) {
    int result = -1;
    Connection conn = null;
    PreparedStatement statement = null;
    final String createPerson = "Insert into person (id, first_name, last_name, username, password, email, dob)" +
            " values (?,?,?,?,?,?,?)";
    final String createUser = "Insert into user (id, user_agreement) values (?,?)";
    try {
      conn = DatabaseConnection.getConnection();
      // String selectPerson = "select  * from person";
      PreparedStatement personStatement = conn.prepareStatement(createPerson);

      personStatement.setInt(1, user.getId());
      personStatement.setString(2, user.getFirstName());
      personStatement.setString(3, user.getLastName());
      personStatement.setString(4, user.getUserName());
      personStatement.setString(5, user.getPassword());
      personStatement.setString(6, user.getEmail());
      personStatement.setDate(7, user.getDob());
      personStatement.executeUpdate();


      PreparedStatement devStatement = conn.prepareStatement(createUser);
      devStatement.setInt(1, user.getId());
      devStatement.setString(2, user.getUserAgreement());
      devStatement.executeUpdate();
      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }


  }
}
