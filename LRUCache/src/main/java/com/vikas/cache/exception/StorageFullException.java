package com.vikas.cache.exception;

public class StorageFullException extends RuntimeException {
  public StorageFullException(String message) {
    super(message);
  }
}
