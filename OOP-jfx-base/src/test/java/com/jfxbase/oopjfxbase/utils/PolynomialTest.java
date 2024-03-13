package com.jfxbase.oopjfxbase.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PolynomialTest {
    Polynomial polynomial=new Polynomial();

    @Test
    void testIsPolynomial(){
        String string="xxx^2+3";
        boolean check=polynomial.isPolynomial(string);
        assertFalse(check);
    }
  
}