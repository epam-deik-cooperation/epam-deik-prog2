package com.epam.training.solution;

import com.epam.training.exercise.Calculator;
import com.epam.training.exercise.Formatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Egy lehetséges megoldás!
 */
public class Refactored {

    public void refactored() {
        Runnable runnable = createRunnable();
        runnable.run();

        Calculator calculator = createCalculator();
        System.out.println("Calculation result: " + calculator.calculate(3));

        List<Integer> inputNumbers = Arrays.asList(1, null, 3, null, 5);
        List<Integer> resultNumbers = inputNumbers
                .stream()
                .filter(Objects::nonNull)       // number -> number != null
                .map(calculator::calculate)     // number -> calculator.calculate(number)
                .collect(Collectors.toList());

        Consumer<Integer> consumerMethod = createConsumerMethod();
        System.out.println("Result numbers: ");
        resultNumbers.forEach(consumerMethod);

        Formatter formatter = createFormatter();
        System.out.println("Formatted numbers: " + formatter.format(resultNumbers));
    }

    private Runnable createRunnable() {
        return () -> System.out.println("Runnable!");
    }

    private Formatter createFormatter() {
        return numbers -> numbers.stream()
                .map(String::valueOf)           // number -> String.valueOf(number)
                .collect(Collectors.joining());
    }

    private Consumer<Integer> createConsumerMethod() {
        return System.out::println;             // number -> System.out.println(number);
    }

    private Calculator createCalculator() {
        return number -> number * number;
    }

}
