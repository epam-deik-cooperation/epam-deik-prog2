package com.epam.training.serializer;

/**
 * Serializer implementation for 'null' value.
 */
public class NullSerializer implements Serializer<Object> {

    @Override
    public String serialize(Object obj, Serializer<Object> mainSerializer) {
        return "null";
    }

    @Override
    public Class<Object> getSourceClass() {
        return Object.class;
    }

}
