package com.epam.training.serializer;

/**
 * Serializer implementation for {@link Number} instances.
 */
public class NumberSerializer implements Serializer<Number> {

    @Override
    public String serialize(Number obj, Serializer<Object> mainSerializer) {
        return obj.toString();
    }

    @Override
    public Class<Number> getSourceClass() {
        return Number.class;
    }

}
