package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.models.Address;

public class AddressImpl implements AddressDao {

  @Override
  public void insertAddress(Address address) {
    int result = -1;
    Connection conn = null;
    PreparedStatement statement = null;
    final String createAddress = "Insert into address (id, street1, primary_address, person)" +
            " values (?,?,?,?)";

    try {
      conn = DatabaseConnection.getConnection();

      PreparedStatement addressStatement = conn.prepareStatement(createAddress);

      addressStatement.setInt(1, address.getId());
      addressStatement.setString(2, address.getStreet1());
      addressStatement.setBoolean(3, address.isPrimary());
      addressStatement.setInt(4, address.getPerson());
      addressStatement.executeUpdate();

      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }


  }

  @Override
  public void deletePrimaryAddress(int personID) {
    final String deleteAddress = "delete from address where person = ? and primary_address = ?";
    Connection conn = null;
    PreparedStatement addressStatement = null;

    try {
      conn = DatabaseConnection.getConnection();

      addressStatement = conn.prepareStatement(deleteAddress);

      addressStatement.setInt(1, personID);
      addressStatement.setBoolean(2, true);
      addressStatement.executeUpdate();

      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }

  @Override
  public void makeAddressPrimary(int personID) {
    final String makeAddress = "update address set primary_address = ? where person = ? and " +
            "primary_address = ?";
    Connection conn = null;
    PreparedStatement addressStatement = null;

    try {
      conn = DatabaseConnection.getConnection();

      addressStatement = conn.prepareStatement(makeAddress);

      addressStatement.setBoolean(1, true);
      addressStatement.setInt(2, personID);
      addressStatement.setBoolean(3, false);
      addressStatement.executeUpdate();

      DatabaseConnection.closeConnection();

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();

    }
  }
}
