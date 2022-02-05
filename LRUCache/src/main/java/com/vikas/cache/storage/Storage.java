package com.vikas.cache.storage;

import com.vikas.cache.exception.KeyNotFoundException;
import com.vikas.cache.exception.StorageFullException;

public interface Storage<Key, Value> {
  void add(Key key, Value value) throws StorageFullException;

  void remove(Key key);

  Value get(Key key) throws KeyNotFoundException;
}
