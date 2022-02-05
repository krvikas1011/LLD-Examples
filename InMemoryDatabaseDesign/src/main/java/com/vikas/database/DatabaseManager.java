package com.vikas.database;

import lombok.Data;

import java.util.HashMap;

@Data
public class DatabaseManager {
  HashMap<String, Database> databases;

  public DatabaseManager() {
    databases = new HashMap<>();
  }

  public void createDatabase(String databaseName) {
    if (databases.containsKey(databaseName)) {
      System.out.println("Database Already Exists");
    } else {
      databases.put(databaseName, new Database());
    }
  }

  public void deleteDatabase(String databaseName) {
    if (databases.containsKey(databaseName)) {
      databases.remove(databaseName);
    } else {
      System.out.println("Database not found");
    }
  }
}
