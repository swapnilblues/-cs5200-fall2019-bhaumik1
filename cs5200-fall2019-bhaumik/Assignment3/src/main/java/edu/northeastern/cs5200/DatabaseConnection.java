package edu.northeastern.cs5200;
import java.sql.*;

public class DatabaseConnection {

  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String URL = "jdbc:mysql://cs5200-fall2019-bhaumik.cqxjicfbcfet.us-east-2.rds.amazonaws.com/CS5200_Assignment3_Fall2019_Bhaumik";
  private static final String USER = "admin";
  private static final String PASSWORD = "admin1234";
  private static java.sql.Connection dbConnection = null;

  public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName(DRIVER);

    if (dbConnection == null) {
      dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
      return dbConnection;
    } else { return dbConnection; } }

  public static void closeConnection() {
    try {
      if (dbConnection != null) {
        dbConnection.close();
        dbConnection = null; }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }
  }
}
