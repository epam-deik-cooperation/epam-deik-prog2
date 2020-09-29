package com.epam.training.overloading;

import java.math.BigInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        BigInteger firstBigInt = new BigInteger("10");
        BigInteger secondBigInt = new BigInteger("20");
        Object thirdBigInt = new BigInteger("30");
        int firstInt = 40;
        int secondInt = 50;
        Integer firstInteger = 60;
        Integer secondInteger = 70;
        double firstDoublePrimitive = 1.11;
        double secondDoublePrimitive = 2.22;
        Double firstDoubleObj = 3.33;
        Double secondDoubleObj = 4.44;

        // https://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.3
        add(firstInt, secondInt);
        add(firstInteger, secondInteger);
        add(firstInt, firstDoublePrimitive);
        add(firstDoublePrimitive, secondDoublePrimitive);
        add(firstDoubleObj, secondDoubleObj);
        add(firstBigInt, secondBigInt);
        add(firstBigInt, secondInt);
        add(firstBigInt, thirdBigInt);

    }

    public static Object add(Object first, Object second) {
        LOGGER.info("Adding Objects {} and {}", first, second);
        return 42;
    }

    public static Integer add(Integer first, Integer second) {
        LOGGER.info("Adding Integers {} and {}", first, second);
        return first + second;
    }

    public static double add(Double first, Double second) {
        LOGGER.info("Adding Doubles {} and {}", first, second);
        return first + second;
    }

    public static double add(double first, double second) {
        LOGGER.info("Adding doubles {} and {}", first, second);
        return first + second;
    }

    public static BigInteger add(BigInteger first, BigInteger second) {
        LOGGER.info("Adding BigIntegers {} and {}", first, second);
        return first.add(second);
    }
}
