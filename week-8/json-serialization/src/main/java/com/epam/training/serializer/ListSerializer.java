package com.epam.training.serializer;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Serializer implementation for {@link List} instances.
 */
public class ListSerializer implements Serializer<List> {

    @Override
    public String serialize(List obj, Serializer<Object> mainSerializer) {
        return (String) obj.stream()
                .map(o -> mainSerializer.serialize(o, mainSerializer))
                .collect(Collectors.joining(",", "[", "]"));
    }

    @Override
    public Class<List> getSourceClass() {
        return List.class;
    }

}
