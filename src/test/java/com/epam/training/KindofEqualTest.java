package com.epam.training;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.testng.annotations.Test;

/**
 * # Kind of equal
 *
 * Adott az alábbi kódrészlet.
 *
 * ```
 * // Given
 * String first = "...";
 * String second = "...";
 * String third = "...";
 *
 * // When
 * var firstMatchesSecondWithEquals = first.equals(second);
 * var firstMatchesSecondWithEqualToOperator = first == second;
 * var firstMatchesThirdWithEquals = first.equals(third);
 * var firstMatchesThirdWithEqualToOperator = first == third;
 *
 * ```
 *
 * Változtasd meg a ```String third = "...";``` sort úgy, hogy a firstMatchesSecondWithEquals,
 * firstMatchesSecondWithEqualToOperator, firstMatchesThirdWithEquals értéke true,
 * a firstMatchesThirdWithEqualToOperator értéke pedig false legyen. Magyarázd meg, mi történik a háttérben.
 */
public class KindofEqualTest {

    @Test
    public void testKindofEqualExercise() {
        // Given
        String first = "...";
        String second = "...";
        // A fenti kettő ugyanarra a objektumra referencia a String interning miatt, az alábbi egy másik, de azonos tartalmú objektum.
        String third = new String("...");

        // When
        var firstMatchesSecondWithEquals = first.equals(second);
        var firstMatchesSecondWithEqualToOperator = first == second;
        var firstMatchesThirdWithEquals = first.equals(third);
        var firstMatchesThirdWithEqualToOperator = first == third;

        // Then
        assertThat(firstMatchesSecondWithEquals, is(true));
        assertThat(firstMatchesSecondWithEqualToOperator, is(true));
        assertThat(firstMatchesThirdWithEquals, is(true));
        assertThat(firstMatchesThirdWithEqualToOperator, is(false));
    }

}
