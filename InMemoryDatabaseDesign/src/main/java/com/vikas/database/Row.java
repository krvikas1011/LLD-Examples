package com.vikas.database;

import lombok.Data;

import java.util.HashMap;

@Data
public class Row {
  private HashMap<String, String> columnData;

  public Row() {
    columnData = new HashMap<>();
  }

  public Row(HashMap<String, String> columnData) {
    this.columnData = columnData;
  }

  public void updateColumnValue(String columnName, String columnValue) {
    if (columnData.containsKey(columnName)) {
      columnData.put(columnName, columnValue);
    } else {
      System.out.println("Column Name not found for update");
    }
  }
}
