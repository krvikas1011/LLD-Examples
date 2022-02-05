package com.vikas.database;

import lombok.Data;
import java.util.HashMap;

@Data
public class Database {
  HashMap<String, Table> tables;

  public Database() {
    tables = new HashMap<>();
  }

  public void createTable(String tableName) {
    if (tables.containsKey(tableName)) {
      System.out.println("Table Already Exists");
    } else {
      tables.put(tableName, new Table());
    }
  }

  public void deleteTable(String tableName) {
    if (tables.containsKey(tableName)) {
      tables.remove(tableName);
    } else {
      System.out.println("Table not found");
    }
  }
}
