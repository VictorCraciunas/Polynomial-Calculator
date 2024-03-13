package com.jfxbase.oopjfxbase.utils;

import java.util.Map;

public class Operations {

    public static Polynomial addPolynomials(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        result.getMonomials().putAll(polynomial1.getMonomials());


        for (Map.Entry<Integer, Integer> entry : polynomial2.getMonomials().entrySet()) {
            Integer power= entry.getKey();
            Integer coeff=entry.getValue();

            if(result.getMonomials().containsKey(power)){
                result.getMonomials().put(power, coeff + result.getMonomials().get(power));
            }
            else{
                result.getMonomials().put(power, coeff);
            }
        }

        return result;
    }

    public static Polynomial substractPolynomials(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        result.getMonomials().putAll(polynomial1.getMonomials());


        for (Map.Entry<Integer, Integer> entry : polynomial2.getMonomials().entrySet()) {
            Integer power= entry.getKey();
            Integer coeff=entry.getValue();

            if(result.getMonomials().containsKey(power)){
                result.getMonomials().put(power, result.getMonomials().get(power) - coeff );
            }
            else{
                result.getMonomials().put(power, -coeff);
            }
        }

        return result;
    }
}
