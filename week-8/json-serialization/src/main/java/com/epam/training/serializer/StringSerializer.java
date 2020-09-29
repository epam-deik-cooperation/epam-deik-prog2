package com.epam.training.serializer;

/**
 * Serializer implementation for {@link String} instances.
 */
public class StringSerializer implements Serializer<String> {

    @Override
    public String serialize(String obj, Serializer<Object> mainSerializer) {
        return "\""+obj+"\"";
    }

    @Override
    public Class<String> getSourceClass() {
        return String.class;
    }

}
