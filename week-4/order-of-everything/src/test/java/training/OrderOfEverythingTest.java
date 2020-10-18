package com.epam.training;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * # Order of everything
 *
 * Collection-ok rendezése esetén jellemzően futási időben derül ki,
 * ha olyan típusú objektumokat próbálunk rendezni, amelyeken az összehasonlítás
 * nem értelmezett (azaz `T` típus esetén nem implementálják a `Comparable<T>` interface-t).
 * Pl. ClassCastException a [Collections.sort()](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List)) esetében,
 * vagy ClassCastException a [Stream.sorted()](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#sorted--) esetében.
 *
 * Írj olyan metódust, amely tetszőleges Collection esetén vissza adja az elemeket
 * egy List-ben növekvően rendezve, amennyiben az elemek összehasonlíthatóak velük azonos típusú objektumokkal.
 * Ha ez a feltétel nem teljesül, az eredményezzen syntax error-t.
 *
 * Például:
 * ```
 *     List<Integer> actualOutput = createOrderedList(input);
 * ```
 * Ahol az `input` `Collection<Integer>` típusú. Természetesen más típusokkal is működnie kell,
 * feltéve, hogy implementálják a Comparable interface-t.
 */
public class OrderOfEverythingTest {

    @ParameterizedTest
    @MethodSource("collectionsToSortDataProvider")
    public void testOrderShouldReturnExpectedListWhenCollectionIsPassed(Collection<Integer> input, List<Integer> expectedOutput) {
        // Given as parameters

        // When
        // createOrderedList(List.of(new OrderOfEverythingTest()));
        // ^ ez piros, az OrderOfEverythingTest nem implementálja a Comparable<OrderOfEverythingTest> -et
        List<Integer> actualOutput = createOrderedList(input);

        // Then
        assertThat(actualOutput, equalTo(expectedOutput));
    }

    private static Stream<Arguments> collectionsToSortDataProvider() {
        return Stream.of(
            Arguments.of(Collections.emptySet(), Collections.emptyList()),
            Arguments.of(Set.of(1), List.of(1)),
            Arguments.of(Set.of(2,1), List.of(1,2))
        );
    }

    private <T extends Comparable<T>> List<T> createOrderedList(Collection<T> input) {
        return input.stream()
            .sorted()
            .collect(Collectors.toList());
    }
}
