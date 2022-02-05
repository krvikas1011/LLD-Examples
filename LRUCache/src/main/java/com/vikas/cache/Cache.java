package com.vikas.cache;

import java.util.Objects;

/**
 * Inspired By - https://github.com/goyal27/cache-lld
 */

public class Cache<Key, Value> {
  private final Storage<Key, Value> storage;
  private final EvictionPolicy<Key> evictionPolicy;

  public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
    this.storage = storage;
    this.evictionPolicy = evictionPolicy;
  }

  public Value get(final Key key) {
    try {
      Value value = storage.get(key);
      evictionPolicy.keyAccessed(key);
      return value;
    } catch (KeyNotFoundException e) {
      System.out.println("Hit a cache miss  for key " + key);
    }
    return null;
  }

  public void put(Key key, Value value) {
    try {
      storage.set(key, value);
      evictionPolicy.keyAccessed(key);
    } catch (StorageFullException storageFullException) {
      System.out.println("Storage full! Trying to evict");
      Key keyToBeRemoved = evictionPolicy.evict();
      if (Objects.isNull(keyToBeRemoved)) {
        throw new InvalidStateException(
            "Invalid State! No storage space left and no keys to evict");
      }
      storage.remove(keyToBeRemoved);
      System.out.println("Evicting key " + keyToBeRemoved);
      put(key, value);
    }
  }
}
