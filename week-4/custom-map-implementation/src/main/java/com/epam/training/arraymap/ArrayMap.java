package com.epam.training.arraymap;

import java.util.*;
import java.util.function.BiPredicate;

/**
 * Custom Map implementation without using Java Collections.
 * This implementation does not allow null keys and
 * the keySet, values, entrySet methods does not support element removal.
 *
 * @param <K> key type parameter
 * @param <V> value type parameter
 */
public class ArrayMap<K, V> implements Map<K, V> {

  private static final int INITIAL_SIZE = 16;
  private static final String NULL_KEY_NOT_SUPPORTED = "This Map implementation does not support null keys!";

  private int size = 0;
  private K[] keys = (K[]) new Object[INITIAL_SIZE];
  private V[] values = (V[]) new Object[INITIAL_SIZE];

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public boolean containsKey(Object key) {
    Objects.requireNonNull(key, NULL_KEY_NOT_SUPPORTED);

    return searchItemInArray(key, keys, Object::equals) != -1;
  }

  @Override
  public boolean containsValue(Object value) {
    int valueIndex = searchItemInArray(value, values, Object::equals);
    return valueIndex > -1 && keys[valueIndex] != null;
  }

  @Override
  public V get(Object key) {
    Objects.requireNonNull(key, NULL_KEY_NOT_SUPPORTED);
    if(size <= 0) {
      return null;
    }

    int keyIndex = searchItemInArray(key, keys, Object::equals);
    if (keyIndex > -1) {
      return values[keyIndex];
    }

    return null;
  }

  @Override
  public V put(K key, V value) {
    Objects.requireNonNull(key, NULL_KEY_NOT_SUPPORTED);

    int keyIndex = searchItemInArray(key, keys, Objects::equals);
    if (keyIndex < 0) {
      keyIndex = findFirstEmptyPlace();
      if (keyIndex < 0) {
        expandArrays();
      }
      keyIndex = size;
    }

    V prevValue = values[keyIndex];

    keys[keyIndex] = key;
    values[keyIndex] = value;
    size++;

    return prevValue;
  }

  @Override
  public V remove(Object key) {
    Objects.requireNonNull(key, NULL_KEY_NOT_SUPPORTED);

    int keyIndex = searchItemInArray(key, keys, Object::equals);
    if (keyIndex > -1) {
      V prevValue = values[keyIndex];

      keys[keyIndex] = null;
      values[keyIndex] = null;
      size--;

      return prevValue;
    }

    return null;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> m) {
    m.forEach(this::put);
  }

  @Override
  public void clear() {
    Arrays.fill(keys, null);
    Arrays.fill(values, null);
    size = 0;
  }

  @Override
  public Set<K> keySet() {
    Set<K> result = new HashSet<>();
    for(K i : keys) {
      if (i != null) {
        result.add(i);
      }
    }

    return result;
  }

  @Override
  public Collection<V> values() {
    Collection<V> result = new ArrayList<>();
    for(V i : values) {
      if (i != null) {
        result.add(i);
      }
    }

    return result;
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    Set<Entry<K, V>> result = new HashSet<>();
    for(int i = 0; i < keys.length; ++i) {
      K key = keys[i];
      if (key != null) {
          V value = values[i];
          result.add(new AbstractMap.SimpleEntry<>(key, value));
      }
    }

    return result;
  }


  private <I> int searchItemInArray(I item, I[] array, BiPredicate<I, I> equalFunction) {
    for (int index = 0; index < array.length; index++) {
      if (equalFunction.test(item, array[index]))
        return index;
    }

    return -1;
  }

  private int findFirstEmptyPlace() {
    return searchItemInArray(null, keys, Objects::equals);
  }

  private void expandArrays() {
    int expandedSize = size * 2;

    keys = Arrays.copyOf(keys, expandedSize);
    values = Arrays.copyOf(values, expandedSize);
  }

}
