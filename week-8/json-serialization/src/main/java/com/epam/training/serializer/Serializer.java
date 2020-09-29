package com.epam.training.serializer;

/**
 * Interface for serializers to use.
 * @param <T> source type for serialization
 */
public interface Serializer<T> {

    /**
     * Returns the given object serialized into JSON.
     * @param obj object to be serialized
     * @param mainSerializer main entry point for serialization
     * @return given object in JSON serialized form
     */
    String serialize(T obj, Serializer<Object> mainSerializer);

    /**
     * Returns source class, used for serializer selection during object processing.
     * @return serialization source class
     */
    Class<T> getSourceClass();

}
