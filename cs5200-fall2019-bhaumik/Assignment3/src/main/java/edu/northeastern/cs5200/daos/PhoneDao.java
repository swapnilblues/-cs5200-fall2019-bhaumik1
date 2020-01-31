package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Phone;

public interface PhoneDao {

  void insertPhone(Phone address);

  void updatePrimaryPhoneByPersonID(int personID, String newPhoneNumber);
}
