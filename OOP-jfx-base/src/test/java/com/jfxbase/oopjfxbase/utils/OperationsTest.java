package com.jfxbase.oopjfxbase.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;


class OperationsTest {

    @ParameterizedTest
    @MethodSource("provideInput")
    void addition() {
    }


    @ParameterizedTest
    @MethodSource("provideInput")
    void subtraction() {
    }


    @ParameterizedTest
    @MethodSource("provideInput")
    void multiplication() {
    }


    @ParameterizedTest
    @MethodSource("provideInput")
    void derivative() {
    }


    @ParameterizedTest
    @MethodSource("provideInput")
    void integrate() {
    }


    private static List<Arguments> provideInput(){
        List<Arguments> arguments = new ArrayList<>();
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();
        Polynomial polynomial3=new Polynomial();


        polynomial1.createPolynomial("2x^2+2x-5");
        polynomial1.createPolynomial("-3x^5-2x^2+3");
        polynomial1.createPolynomial("x^3+2x-1");
        arguments.add(Arguments.of(2, polynomial1, polynomial2));
        arguments.add(Arguments.of(4, polynomial2, polynomial3));
        arguments.add(Arguments.of(12, polynomial3, polynomial1));
        return arguments;
    }

}