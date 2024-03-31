package com.jfxbase.oopjfxbase.utils;

import com.jfxbase.oopjfxbase.AppLogic.Operations;
import com.jfxbase.oopjfxbase.AppLogic.Polynomial;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class OperationsTest {

    @ParameterizedTest
    @MethodSource("provideInput")
    void addition(Polynomial p1, Polynomial p2, Polynomial expectedSum) {
        Polynomial result = Operations.addition(p1, p2);
        assertEquals(expectedSum.getMonomials().toString(), result.getMonomials().toString());
    }


    @ParameterizedTest
    @MethodSource("provideInput")
    void subtraction(Polynomial p1, Polynomial p2, Polynomial expectedDifference) {
        Polynomial result = Operations.subtraction(p1, p2);
        assertEquals(expectedDifference.getMonomials().toString(), result.getMonomials().toString());
    }


    @ParameterizedTest
    @MethodSource("provideInput")
    void multiplication(Polynomial p1, Polynomial p2, Polynomial expectedProduct) {
        Polynomial result = Operations.multiplication(p1, p2);
        assertEquals(expectedProduct.getMonomials().toString(), result.getMonomials().toString());
    }


    @ParameterizedTest
    @MethodSource("provideInputForDerivative")
    void derivative(Polynomial p, Polynomial expectedDerivative) {
        Polynomial result = Operations.derivative(p);
        assertEquals(expectedDerivative.getMonomials().toString(), result.getMonomials().toString());
    }


    @ParameterizedTest
    @MethodSource("provideInputForIntegration")
    void integrate(Polynomial p, Polynomial expectedIntegral) {
        Polynomial result = Operations.integrate(p);
        assertEquals(expectedIntegral.getMonomials().toString(), result.getMonomials().toString());
    }


    private static List<Arguments> provideInput() {
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial p3 = new Polynomial();
        Polynomial result1 = new Polynomial();
        Polynomial result2 = new Polynomial();
        Polynomial result3 = new Polynomial();

        p1.createPolynomial("x^2+1");
        p2.createPolynomial("-x^2+1");
        p3.createPolynomial("x^5+x^2-x+3");


        result1.createPolynomial("2");
        result2.createPolynomial("x^5-x+4");
        result3.createPolynomial("x^5+2x^2-x+4");
        arguments.add(Arguments.of(p1, p2, result1));
        arguments.add(Arguments.of(p2, p3, result2));
        arguments.add(Arguments.of(p3, p1, result3));
        return arguments;
    }

    private static List<Arguments> provideInputForDerivative() {
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1 = new Polynomial();
        Polynomial result1 = new Polynomial();

        p1.createPolynomial("2x+2");
        result1.createPolynomial("2");
        arguments.add(Arguments.of(p1, result1));
        return arguments;
    }

    private static List<Arguments> provideInputForIntegration() {
        List<Arguments> arguments = new ArrayList<>();
        Polynomial p1 = new Polynomial();
        Polynomial result1 = new Polynomial();

        p1.createPolynomial("2x+2");
        result1.createPolynomial("x^2+2");
        arguments.add(Arguments.of(p1, result1));
        return arguments;
    }

}