package com.epam.training.serializer;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Default serializer implementation for plain {@link Object} instances.
 */
public class ObjectSerializer implements Serializer<Object> {

    @Override
    public String serialize(Object obj, Serializer<Object> mainSerializer) {
        return Arrays.stream(obj.getClass().getDeclaredFields())
                .map(field -> {
                    try {
                        String name = field.getName();

                        if (!field.canAccess(obj)) {
                            field.setAccessible(true);
                        }

                        String value = mainSerializer.serialize(field.get(obj), mainSerializer);

                        return String.format("\"%s\":%s", name, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return "";
                })
                .collect(Collectors.joining(",", "{", "}"));
    }

    @Override
    public Class<Object> getSourceClass() {
        return Object.class;
    }

}
