package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Phone;

public class PhoneImpl implements PhoneDao {

  @Override
  public void insertPhone(Phone phone) {
    int result = -1;
    Connection conn = null;
    PreparedStatement statement = null;
    final String createPhone = "Insert into phone (id, phone, primary_number, person)" +
            " values (?,?,?,?)";

    try {
      conn = DatabaseConnection.getConnection();

      PreparedStatement phoneStatement = conn.prepareStatement(createPhone);

      phoneStatement.setInt(1, phone.getId());
      phoneStatement.setString(2, phone.getPhone());
      phoneStatement.setBoolean(3, phone.isPrimary());
      phoneStatement.setInt(4, phone.getPerson());
      phoneStatement.executeUpdate();

      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @Override
  public void updatePrimaryPhoneByPersonID(int personID, String newPhoneNumber) {

    Connection conn = null;
    PreparedStatement statement = null;
    final String updatePhone = "update phone set phone = ? where person = ? and primary_number = ?";
    try {
      conn = DatabaseConnection.getConnection();

      PreparedStatement phoneStatement = conn.prepareStatement(updatePhone);

      phoneStatement.setString(1, newPhoneNumber);
      phoneStatement.setInt(2, personID);
      phoneStatement.setBoolean(3, true);
      phoneStatement.executeUpdate();

      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }


}

