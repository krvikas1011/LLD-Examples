package com.vikas.database;

import lombok.Data;

import java.util.HashMap;

@Data
public class Table {
  private HashMap<Integer, Row> rows;

  public Table() {
    rows = new HashMap<>();
  }

  public void createRecord(int id, Row rowData) {
    if (!rows.containsKey(id)) {
      rows.put(id, rowData);
    } else {
      System.out.println("Row Id already exists");
    }
  }

  public void updateRecord(int id, String columnName, String updatedValue) {
    if (rows.containsKey(id)) {
      rows.get(id).updateColumnValue(columnName, updatedValue);
    } else {
      System.out.println("Row Id not found");
    }
  }

  public void deleteRecord(int id, Row rowData) {
    if (rows.containsKey(id)) {
      rows.remove(id);
    } else {
      System.out.println("Row Id not found");
    }
  }
}
