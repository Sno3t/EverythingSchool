package com.example.demo;

import java.util.stream.DoubleStream;

public class Calculator {
    /**
     * @param operands the operant
     * @return double
     */
    static double add(double... operands) {
        return DoubleStream.of(operands)
                .sum();
    }

    /**
     * @param operands the operant
     * @return double
     */
    static double multiply(double... operands) {
        return DoubleStream.of(operands)
                .reduce(1, (a, b) -> a * b);
    }
}