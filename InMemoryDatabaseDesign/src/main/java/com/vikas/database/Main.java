package com.vikas.database;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    DatabaseManager databaseManager = new DatabaseManager();
    databaseManager.createDatabase("VikasDB");
    Database database = new Database();
    database.createTable("VikasTable");
    Table table = new Table();
    HashMap<String, String> columnData = new HashMap<>();
    columnData.put("k1", "v1");
    columnData.put("k2", "v2");
    columnData.put("k3", "v3");
    Row row = new Row(columnData);
    table.createRecord(1, row);
    table.createRecord(2, row);
    table.updateRecord(1, "k2", "v5");
  }
}
