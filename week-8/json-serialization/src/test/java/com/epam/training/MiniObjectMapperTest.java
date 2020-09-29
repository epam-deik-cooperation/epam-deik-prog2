package com.epam.training;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MiniObjectMapperTest {

    public static final String TEST_STRING = "string";
    public static final Long TEST_NUMBER = 12345L;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final MiniObjectMapper underTest = new MiniObjectMapper();

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void toJsonShouldWorkAsJacksonObjectMapperWhenSerializing(Object obj) throws JsonProcessingException {
        // Given
        String expected = objectMapper.writeValueAsString(obj);

        // When
        String actual = underTest.toJson(obj);

        // Then
        assertThat(actual, equalTo(expected));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(generateExampleData()),
                Arguments.of(TEST_STRING),
                Arguments.of(TEST_NUMBER),
                Arguments.of(TEST_NUMBER.intValue()),
                Arguments.of(List.of(generateExampleData(), generateExampleData())),
                Arguments.of(true),
                Arguments.of((Object) null)
        );
    }

    private static ExampleData generateExampleData() {
        ExampleData.InnerData innerData = new ExampleData.InnerData("innerStringSerialized", 2131);
        return new ExampleData(
                "outerStringSerialized",
                1113,
                1134,
                1515L,
                3.141592654,
                Arrays.asList("first", "second", "third"),
                innerData,
                false);
    }
}