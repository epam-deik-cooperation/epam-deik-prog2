package com.epam.training;

import com.epam.training.serializer.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Small JSON serializer supporting strings, numbers, lists, booleans, null values and embedded objects.
 */
public class MiniObjectMapper {

  private static final Serializer<?> nullSerializer = new NullSerializer();
  private static final List<Serializer<?>> SERIALIZER_LIST = List.of(
          new StringSerializer(),
          new NumberSerializer(),
          new BooleanSerializer(),
          new ListSerializer(),
          new ObjectSerializer()
  );

  private final MainSerializer mainSerializer;

  /**
   * Creates a new MiniObjectMapper instance.
   */
  public MiniObjectMapper() {
    this.mainSerializer = new MainSerializer(SERIALIZER_LIST, nullSerializer);
  }

  /**
   * Creates a new MiniObjectMapper instance with the additional given serializers.
   * @param customSerializerList custom serializer list to be used
   */
  public MiniObjectMapper(List<Serializer<?>> customSerializerList) {
    List<Serializer<?>> finalSerializerList = new ArrayList<>(customSerializerList);
    finalSerializerList.addAll(SERIALIZER_LIST);
    this.mainSerializer = new MainSerializer(finalSerializerList, nullSerializer);
  }

  /**
   * Returns the given object serialized into JSON.
   * @param obj object to be serialized
   * @return given object in JSON serialized form
   */
  public String toJson(Object obj) {
    return mainSerializer.serialize(obj, mainSerializer);
  }

}

