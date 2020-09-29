package com.epam.training.serializer;

import java.util.List;

/**
 * Serializer implementation to be used as the main entry point for JSON serialization.
 */
public class MainSerializer implements Serializer<Object> {

    private final List<Serializer<?>> serializerList;
    private final Serializer<?> nullSerializer;

    public MainSerializer(List<Serializer<?>> serializerList, Serializer<?> nullSerializer) {
        this.serializerList = serializerList;
        this.nullSerializer = nullSerializer;
    }

    @Override
    public String serialize(Object obj, Serializer<Object> mainSerializer) {
        Serializer<Object> selectedSerializer = (Serializer<Object>) selectSerializer(obj);
        return selectedSerializer.serialize(obj, this);
    }

    @Override
    public Class<Object> getSourceClass() {
        return Object.class;
    }

    private Serializer<?> selectSerializer(Object obj) {
        return serializerList.stream()
                .filter(serializer -> serializer.getSourceClass().isInstance(obj))
                .findFirst()
                .orElse(nullSerializer);
    }

}
