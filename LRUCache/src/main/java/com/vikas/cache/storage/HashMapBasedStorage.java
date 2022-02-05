package com.vikas.cache.storage;

import com.vikas.cache.exception.KeyNotFoundException;
import com.vikas.cache.exception.StorageFullException;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {
  @Override
  public void add(Object o, Object o2) throws StorageFullException {}

  @Override
  public void remove(Object o) {}

  @Override
  public Value get(Object o) throws KeyNotFoundException {
    return null;
  }
}
