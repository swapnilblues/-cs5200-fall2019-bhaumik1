package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.Address;

public interface AddressDao {

  void insertAddress(Address address);

  void deletePrimaryAddress(int personID);

  void makeAddressPrimary(int personID);
}
