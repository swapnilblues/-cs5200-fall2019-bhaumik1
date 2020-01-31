package edu.northeastern.cs5200;

import com.example.demo.DemoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.jws.WebService;
import javax.management.relation.Role;
import javax.swing.*;

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

/**
 * The insert portion is between lines 68 and line 270.
 * The update portion is between lines 273 and line 346.
 * The delete portion is between lines 350 and line 406.
 *
 *
 */
@SpringBootApplication
public class Hw_jdbc_last_first {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    SpringApplication.run(DemoApplication.class, args);

    //---------------------------Insert


    //--------------------------Insert Person

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
    //DatabaseConnection.closeConnection();


    devDao.createDeveloper(new Developer("5432trew", 23, "Bob", "Marley",
            "bob", "bob", "bob@marley.com", null));
    addressDao.insertAddress(new Address(3, "Dummy_Address_Bob", null, null, null, null,
            true, 23));
    addressDao.insertAddress(new Address(4, "Dummy_Address_Bob", null, null, null, null,
            false, 23));
    phoneDao.insertPhone(new Phone(3, "003", true, 23));
    phoneDao.insertPhone(new Phone(4, "004", false, 23));
    DatabaseConnection.closeConnection();

  devDao.createDeveloper(new Developer("6543ytre", 34, "Charles", "Gracia",
            "charlie", "charlie", "chuch@garcia.com", null));
    addressDao.insertAddress(new Address(5, "Dummy_Address_Charlie", null, null, null, null,
            true, 34));
    addressDao.insertAddress(new Address(6, "Dummy_Address_Charlie", null, null, null, null,
            false, 34));
    phoneDao.insertPhone(new Phone(5, "005", true, 34));
    phoneDao.insertPhone(new Phone(6, "006", false, 34));


    userDao.createUser(new User(null, 45, "Dan", "Martin",
            "dan", "dan", "dan@martin.com", null));
    addressDao.insertAddress(new Address(7, "Dummy_Address_Dan", null, null, null, null,
            true, 45));
    addressDao.insertAddress(new Address(8, "Dummy_Address_Dan", null, null, null, null,
            false, 45));
    phoneDao.insertPhone(new Phone(7, "007", true, 45));
    phoneDao.insertPhone(new Phone(8, "008", false, 45));


    userDao.createUser(new User(null, 56, "Ed", "Karaz",
            "ed", "ed", "ed@kar.com", null));
    addressDao.insertAddress(new Address(9, "Dummy_Address_Ed", null, null, null, null,
            true, 56));
    addressDao.insertAddress(new Address(10, "Dummy_Address_Ed", null, null, null, null,
            false, 56));
    phoneDao.insertPhone(new Phone(9, "009", true, 56));
    phoneDao.insertPhone(new Phone(10, "010", false, 56));

//    DatabaseConnection.closeConnection();


    //--------------------------Insert Website

    WebsiteDao webDao = new WebsiteImpl();
    RoleDao roleDao = new RoleImpl();

    Date date = new Date(Calendar.getInstance().getTime().getTime());

    webDao.createWebsiteForDeveloper(12,new Website(123,"Facebook",
            "an online social media and social networking service",
            date, date, 1234234));

    roleDao.assignWebsiteRole(12,123,"Owner");
    roleDao.assignWebsiteRole(23,123,"Editor");
    roleDao.assignWebsiteRole(34,123,"Admin");


    webDao.createWebsiteForDeveloper(23,new Website(234,"Twitter",
            "an online social media and social networking service",
            date, date, 4321543));

    roleDao.assignWebsiteRole(23,234,"Owner");
    roleDao.assignWebsiteRole(34,234,"Editor");
    roleDao.assignWebsiteRole(12,234,"Admin");


    webDao.createWebsiteForDeveloper(34,new Website(345,"Wikipedia",
            "a free online encyclopedia",
            date, date, 3456654));

    roleDao.assignWebsiteRole(34,345,"Owner");
    roleDao.assignWebsiteRole(12,345,"Editor");
    roleDao.assignWebsiteRole(23,345,"Admin");

    webDao.createWebsiteForDeveloper(12,new Website(456,"CNN",
            "an American basic cable and satellite television news channel",
            date, date, 6543345));

    roleDao.assignWebsiteRole(12,456,"Owner");
    roleDao.assignWebsiteRole(23,456,"Editor");
    roleDao.assignWebsiteRole(34,456,"Admin");

    webDao.createWebsiteForDeveloper(23,new Website(567,"CNET",
            "an American media website that publishes reviews, news, articles, " +
                    "blogs, podcasts and videos on technology and consumer electronics",
            date, date, 5433455));

    roleDao.assignWebsiteRole(23,567,"Owner");
    roleDao.assignWebsiteRole(34,567,"Editor");
    roleDao.assignWebsiteRole(12,567,"Admin");


    webDao.createWebsiteForDeveloper(34,new Website(678,"Gizmodo",
            "a design, technology, science and science fiction website that also writes articles on politics",
            date, date, 4322345));

    roleDao.assignWebsiteRole(34,678,"Owner");
    roleDao.assignWebsiteRole(12,678,"Editor");
    roleDao.assignWebsiteRole(23,678,"Admin");

//    DatabaseConnection.closeConnection();



    PageDao pageDao = new PageImpl();
    roleDao = new RoleImpl();

    //Date date = new Date(Calendar.getInstance().getTime().getTime());

    pageDao.createPageForWebsite(567, new Page(123, "Home", "Landing page",
            Date.valueOf("2019-07-04"),Date.valueOf("2019-10-20"), 123434));
    roleDao.assignPageRole(12,123,"Editor");
    roleDao.assignPageRole(23,123,"Reviewer");
    roleDao.assignPageRole(34,123,"Writer");

    pageDao.createPageForWebsite(678, new Page(234, "About", "Website description",
            Date.valueOf("2019-07-04"),Date.valueOf("2019-10-20"), 234545));
    roleDao.assignPageRole(23,234,"Editor");
    roleDao.assignPageRole(34,234,"Reviewer");
    roleDao.assignPageRole(12,234,"Writer");

    pageDao.createPageForWebsite(345, new Page(345, "Contact",
            "Addresses, phones, and contact info",
            Date.valueOf("2019-07-04"),Date.valueOf("2019-10-20"), 345656));
    roleDao.assignPageRole(34,345,"Editor");
    roleDao.assignPageRole(12,345,"Reviewer");
    roleDao.assignPageRole(23,345,"Writer");

    pageDao.createPageForWebsite(456, new Page(456, "Preferences",
            "Where users can configure their preferences",
            Date.valueOf("2019-07-04"),Date.valueOf("2019-10-20"), 456776));
    roleDao.assignPageRole(12,456,"Editor");
    roleDao.assignPageRole(23,456,"Reviewer");
    roleDao.assignPageRole(34,456,"Writer");


    pageDao.createPageForWebsite(567, new Page(567, "Profile",
            "Users can configure their personal information",
            Date.valueOf("2019-07-04"),Date.valueOf("2019-10-20"), 567878));
    roleDao.assignPageRole(23,567,"Editor");
    roleDao.assignPageRole(34,567,"Reviewer");
    roleDao.assignPageRole(12,567,"Writer");

    //DatabaseConnection.closeConnection();



    //----------------------------Widget Insert


    WidgetDao widgetDao = new WidgetImpl();

    widgetDao.createWidgetForPage(123, new Widget(123,"head123",0,
            0,null,null,"Welcome",0,0,null,
            null,null,false,false,
            edu.northeastern.cs5200.models.Dtype.Heading));

    widgetDao.createWidgetForPage(234, new Widget(234,"post234",0,
            0,null,null,"<p>Lorem</p>",0,0,null,
            null,null,false,false,
            Dtype.Html));

    widgetDao.createWidgetForPage(345, new Widget(345,"head345",0,
            0,null,null,"Hi",1,0,null,
            null,null,false,false,
            edu.northeastern.cs5200.models.Dtype.Heading));

    widgetDao.createWidgetForPage(345, new Widget(456,"intro456",0,
            0,null,null,"<h1>Hi</h1>",2,0,null,
            null,null,false,false,
            Dtype.Html));

    widgetDao.createWidgetForPage(345, new Widget(567,"image345",50,
            100,null,null,null,3,0,null,
            "/img/567.png",null,false,false,
            Dtype.Image));

    widgetDao.createWidgetForPage(456, new Widget(678,"video456",400,
            300,null,null,null,0,0,null,
            null,"https://youtu.be/h67VX51QXiQ",false,false,
            Dtype.YouTube));

    DatabaseConnection.closeConnection();


    //-------------------------------------Update

    //--------------------Update 1

    DeveloperDao developerDao = new DeveloperImpl();
    Developer devObj = developerDao.findDeveloperByUsername("charlie");
    phoneDao = new PhoneImpl();
    phoneDao.updatePrimaryPhoneByPersonID(devObj.getId(),"333-444-5555");
    DatabaseConnection.closeConnection();


    //--------------------Update 2


     widgetDao = new WidgetImpl();
     Widget widgetObj = widgetDao.findWidgetByOrder(2);
     widgetObj.setOrder(widgetObj.getOrder() - 1);
     widgetDao.updateWidget(widgetObj.getId(),widgetObj);

     widgetObj = widgetDao.findWidgetByOrder(3);
     widgetObj.setOrder(widgetObj.getOrder() - 1);
     widgetDao.updateWidget(widgetObj.getId(),widgetObj);

     widgetObj = widgetDao.findWidgetByName("head345");
     widgetObj.setOrder(3);
     widgetDao.updateWidget(widgetObj.getId(),widgetObj);

     //DatabaseConnection.closeConnection();


    //---------------------------- Update 3


    WebsiteDao websiteDao = new WebsiteImpl();
    Website websiteObj;
    websiteObj = websiteDao.findWebsiteByName("CNET");


    pageDao = new PageImpl();
    Collection<Page> pages;
    pages = pageDao.findPagesForWebsite(websiteObj.getId());

    for (Page page : pages) {
      page.setTitle("CNET-" + page.getTitle());
      pageDao.updatePage(page.getId(), page);
    }

    //DatabaseConnection.closeConnection();



    //---------------------------Update 4

    developerDao = new DeveloperImpl();
    Developer developerObj;
    developerObj = developerDao.findDeveloperByUsername("charlie");
    int idCharlie = developerObj.getId();
    developerObj = developerDao.findDeveloperByUsername("bob");
    int idBob = developerObj.getId();
    //System.out.println(idCharlie +"\t"+ idBob);
    pageDao = new PageImpl();
    Page pageObj;
    pageObj = pageDao.findPageByTitle("CNET-Home");
    roleDao = new RoleImpl();
    int pageID = pageObj.getId();
    String roleCharlie = roleDao.findPageRoleForDeveloper(idCharlie,pageID);
    String roleBob = roleDao.findPageRoleForDeveloper(idBob,pageID);

    roleDao.deletePageRole(idBob,pageID,roleBob);
    roleDao.deletePageRole(idCharlie,pageID,roleCharlie);
    roleDao.assignPageRole(idBob,pageID,roleCharlie);
    roleDao.assignPageRole(idCharlie,pageID,roleBob);

    DatabaseConnection.closeConnection();


    //-----------------------------Delete

    //----------------------------------Delete 1

    developerDao = new DeveloperImpl();
    Developer developerObj1;
    developerObj1 = developerDao.findDeveloperByUsername("alice");
    int idAlice = developerObj1.getId();
    //System.out.println(idAlice);
    addressDao = new AddressImpl();
    addressDao.deletePrimaryAddress(idAlice);
    addressDao.makeAddressPrimary(idAlice);

    DatabaseConnection.closeConnection();

    //------------------------------------Delete 2

    widgetDao = new WidgetImpl();
    Widget lastWidget = new Widget();
    lastWidget.setOrder(-1);
    pageDao = new PageImpl();
    Page page = pageDao.findPageByTitle("Contact");
    Collection<Widget> widgets = widgetDao.findWidgetsForPage(page.getId());
    for (Widget widget : widgets) {
      if(lastWidget.getOrder() < widget.getOrder()) {
        lastWidget = widget;
      }
    }

    widgetDao.deleteWidget(lastWidget.getId());
    DatabaseConnection.closeConnection();


    //------------------------------------Delete 3

    websiteDao = new WebsiteImpl();
    websiteObj = websiteDao.findWebsiteByName("Wikipedia");
    int wikiID = websiteObj.getId();
    Page lastUpdatedPage = new Page();
    lastUpdatedPage.setUpdated(Date.valueOf("1900-01-01"));
    pageDao = new PageImpl();
    pages = pageDao.findPagesForWebsite(wikiID);

    for(Page page1: pages) {
        if(page.getUpdated().after(lastUpdatedPage.getUpdated())) {
          lastUpdatedPage = page1;
        }
    }
    pageDao.deletePage(lastUpdatedPage.getId());
    DatabaseConnection.closeConnection();


   //-------------------------------- Delete 4

    websiteDao = new WebsiteImpl();
    Website website = websiteDao.findWebsiteByName("CNET");
    int iDCNET = website.getId();
    websiteDao.deleteWebsite(iDCNET);
    DatabaseConnection.closeConnection();

  }



}
