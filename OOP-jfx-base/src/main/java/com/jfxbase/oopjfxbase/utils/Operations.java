package com.jfxbase.oopjfxbase.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Operations {

    public static Polynomial addition(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        result.getMonomials().putAll(polynomial1.getMonomials());


        for (Map.Entry<Integer, Double> entry : polynomial2.getMonomials().entrySet()) {
            Integer power= entry.getKey();
            Double coeff=entry.getValue();

            if(result.getMonomials().containsKey(power)){
                result.getMonomials().put(power, coeff + result.getMonomials().get(power));
            }
            else{
                result.getMonomials().put(power, coeff);
            }
        }
        result.updatePolynomial();
        return result;
    }

    public static Polynomial subtraction(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result = new Polynomial();
        result.getMonomials().putAll(polynomial1.getMonomials());


        for (Map.Entry<Integer, Double> entry : polynomial2.getMonomials().entrySet()) {
            Integer power= entry.getKey();
            Double coeff=entry.getValue();

            if(result.getMonomials().containsKey(power)){
                result.getMonomials().put(power, result.getMonomials().get(power) - coeff );
            }
            else{
                result.getMonomials().put(power, -coeff);
            }

            result.updatePolynomial();
        }
        result.updatePolynomial();
        return result;
    }

    public static Polynomial multiplication(Polynomial polynomial1, Polynomial polynomial2){
        Polynomial result=new Polynomial();

        for(Map.Entry<Integer,Double> entry1 : polynomial1.getMonomials().entrySet()){
            for (Map.Entry<Integer, Double> entry2 : polynomial2.getMonomials().entrySet()) {
                Integer power=entry1.getKey()+entry2.getKey();
                Double coeff=entry1.getValue()*entry2.getValue();
                if(result.getMonomials().containsKey(power)){
                    result.getMonomials().put(power, coeff + result.getMonomials().get(power));
                }
                else {
                    result.getMonomials().put(power, coeff);
                }

            }
        }
        return result;
    }

    public static Polynomial derivative(Polynomial polynomial){
        Polynomial result=new Polynomial();

        for(Map.Entry<Integer,Double> entry: polynomial.getMonomials().entrySet()){
            Integer power=entry.getKey()-1;
            Double coeff=entry.getValue()* entry.getKey();

            if(power >= 0){
                result.getMonomials().put(power,coeff);
            }
        }

        return result;
    }

    public static Polynomial integrate(Polynomial polynomial){
        Polynomial result=new Polynomial();


        for(Map.Entry<Integer,Double> entry: polynomial.getMonomials().entrySet()){
            Integer power=entry.getKey()+1;
            Double coeff=entry.getValue()/ (entry.getKey()+1);

            result.getMonomials().put(power,coeff);
        }

        return result;
    }

    public static List<Polynomial> divide(Polynomial n, Polynomial d){
        List<Polynomial> result = new ArrayList<>();
        Polynomial q = new Polynomial();
        Polynomial r = new Polynomial();

        r.getMonomials().putAll(n.getMonomials());
        q.getMonomials().put(0, 0.0);

        while (!r.getMonomials().isEmpty() && r.getDegree() >= d.getDegree()) {
            Polynomial t = new Polynomial();
            Double coeff = r.getLeadCoeff() / d.getLeadCoeff();
            Integer power = r.getDegree() - d.getDegree();
            t.getMonomials().put(power, coeff);
            q = Operations.addition(q, t);
            r = Operations.subtraction(r, Operations.multiplication(t, d));
        }

        result.add(q);
        result.add(r);
        return result;
    }


}
