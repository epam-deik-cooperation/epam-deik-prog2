package com.epam.training.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Adott egy “legacy” kód mely tartalmaz anonymus interface implementációkat, ciklusokat és feltételes kifejezések.
 * Ebben a feladatban ezt a “legacy” kódot szeretnénk átírni lambda kifejezések segítségével (metódus referencia használata előnyt jelent).
 *
 * A program jelenlegi kimenete:
 *  Runnable!
 *  Calculation result: 9
 *  Result numbers:
 *  1
 *  9
 *  25
 *  Formatted numbers: 1925
 */
public class LegacyRefactoring {

    public void legacy() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable!");
            }
        };
        runnable.run();

        Calculator calculator = new Calculator() {
            @Override
            public Integer calculate(Integer number) {
                return number * number;
            }
        };

        Integer result = calculator.calculate(3);
        System.out.println("Calculation result: " + result);

        List<Integer> inputNumbers = Arrays.asList(1, null, 3, null, 5);
        List<Integer> resultNumbers = new ArrayList<>();
        for (Integer number : inputNumbers) {
            if (number != null) {
                Integer calculationResult = calculator.calculate(number);
                resultNumbers.add(calculationResult);
            }
        }

        Consumer<Integer> method = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        System.out.println("Result numbers: ");
        resultNumbers.forEach(method);

        Formatter formatter = new Formatter() {
            @Override
            public String format(List<Integer> numbers) {
                StringBuilder sb = new StringBuilder();
                for (Integer number : numbers) {
                    String stringValueOfNumber = String.valueOf(number);
                    sb.append(stringValueOfNumber);
                }
                return sb.toString();
            }
        };
        System.out.println("Formatted numbers: " + formatter.format(resultNumbers));
    }

}