package edu.northeastern.cs5200.daos;

public interface RoleDao {

  void assignWebsiteRole(int developerId, int websiteId, String role);

  void assignPageRole(int developerId, int pageId, String role);

  void deleteWebsiteRole(int developerId, int websiteId, String role);

  void deletePageRole(int developerId, int pageId, String role);

  String findPageRoleForDeveloper(int developerId, int pageId);

}
