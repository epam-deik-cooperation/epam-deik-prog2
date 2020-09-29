package com.epam.training.serializer;

/**
 * Serializer implementation for {@link Boolean} instances.
 */
public class BooleanSerializer implements Serializer<Boolean> {

    @Override
    public String serialize(Boolean obj, Serializer<Object> mainSerializer) {
        return obj ? "true" : "false";
    }

    @Override
    public Class<Boolean> getSourceClass() {
        return Boolean.class;
    }

}
