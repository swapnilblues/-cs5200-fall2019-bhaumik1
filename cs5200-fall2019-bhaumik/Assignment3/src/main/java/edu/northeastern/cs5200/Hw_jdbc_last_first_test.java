package edu.northeastern.cs5200;

import com.example.demo.DemoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import edu.northeastern.cs5200.DatabaseConnection;
import edu.northeastern.cs5200.daos.AddressDao;
import edu.northeastern.cs5200.daos.AddressImpl;
import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.DeveloperImpl;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.PageImpl;
import edu.northeastern.cs5200.daos.PhoneDao;
import edu.northeastern.cs5200.daos.PhoneImpl;
import edu.northeastern.cs5200.daos.PriviledgeDao;
import edu.northeastern.cs5200.daos.PriviledgeImpl;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.RoleImpl;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.UserImpl;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WebsiteImpl;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.daos.WidgetImpl;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Dtype;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

@SpringBootApplication
class Hw_jdbc_last_first_test {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    //
    //
    SpringApplication.run(DemoApplication.class, args);

    DeveloperDao devDao = new DeveloperImpl();
    UserDao userDao = new UserImpl();
    AddressDao addressDao = new AddressImpl();
    PhoneDao phoneDao = new PhoneImpl();

    devDao.createDeveloper(new Developer("4321rewq", 12, "Alice", "Wonder",
            "alice", "alice", "alice@wonder.com", null));
    addressDao.insertAddress(new Address(1, "Dummy_Address_Alice", null, null, null, null,
            true, 12));
    addressDao.insertAddress(new Address(2, "Dummy_Address_Alice", null, null, null, null,
            false, 12));
    phoneDao.insertPhone(new Phone(1, "001", true, 12));
    phoneDao.insertPhone(new Phone(2, "002", false, 12));
    DatabaseConnection.closeConnection();


    /*devDao.createDeveloper(new Developer("5432trew", 23, "Bob", "Marley",
            "bob", "bob", "bob@marley.com", null));
    addressDao.insertAddress(new Address(3, "Dummy_Address_Bob", null, null, null, null,
            true, 23));
    addressDao.insertAddress(new Address(4, "Dummy_Address_Bob", null, null, null, null,
            false, 23));
    phoneDao.insertPhone(new Phone(3, "003", true, 23));
    phoneDao.insertPhone(new Phone(4, "004", false, 23));
    DatabaseConnection.closeConnection();
*/
  /*  devDao.createDeveloper(new Developer("6543ytre", 34, "Charles", "Gracia",
            "charlie", "charlie", "chuch@garcia.com", null));
    addressDao.insertAddress(new Address(5, "Dummy_Address_Charlie", null, null, null, null,
            true, 34));
    addressDao.insertAddress(new Address(6, "Dummy_Address_Charlie", null, null, null, null,
            false, 34));
    phoneDao.insertPhone(new Phone(5, "005", true, 34));
    phoneDao.insertPhone(new Phone(6, "006", false, 34));


    userDao.createUser(new User("", 45, "Dan", "Martin",
            "dan", "dan", "dan@martin.com", null));
    addressDao.insertAddress(new Address(7, "Dummy_Address_Dan", null, null, null, null,
            true, 45));
    addressDao.insertAddress(new Address(8, "Dummy_Address_Dan", null, null, null, null,
            false, 45));
    phoneDao.insertPhone(new Phone(7, "007", true, 45));
    phoneDao.insertPhone(new Phone(8, "008", false, 45));


    userDao.createUser(new User("", 56, "Ed", "Karaz",
            "ed", "ed", "ed@kar.com", null));
    addressDao.insertAddress(new Address(9, "Dummy_Address_Ed", null, null, null, null,
            true, 56));
    addressDao.insertAddress(new Address(10, "Dummy_Address_Ed", null, null, null, null,
            false, 56));
    phoneDao.insertPhone(new Phone(9, "009", true, 56));
    phoneDao.insertPhone(new Phone(10, "010", false, 56));

    DatabaseConnection.closeConnection();
*/
  }
}
