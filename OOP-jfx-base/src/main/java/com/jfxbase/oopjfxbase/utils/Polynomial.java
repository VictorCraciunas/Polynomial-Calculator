package com.jfxbase.oopjfxbase.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    Map<Integer,Double> monomials=new HashMap<>();


    public boolean isPolynomial(String inputMonomial){
        String regex="^([+-]?\\b([1-9]\\d*)?(x(\\^\\d+)?)?)*$";


        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(inputMonomial);


        if(matcher.find()){
            return true;
        }

        else {
            return false;
        }

    }

    public void createPolynomial(String polynomial){

        String monomial="([+-])?\\b([1-9]\\d*)?(x(\\^\\d+)?)?";

        Pattern pattern=Pattern.compile(monomial);
        Matcher matcher=pattern.matcher(polynomial);

        String match;


        while(matcher.find()){
            match= matcher.group();
            if(!match.isEmpty()){
                insertMonomial(matcher);
            }
        }

    }

    private void insertMonomial(Matcher matcher){
        double coeff;
        int power;


        if (matcher.group(2) == null){
            coeff=1;
        }
        else {
            coeff=Integer.parseInt(matcher.group(2));
        }


        if(matcher.group(1)!= null && matcher.group(1).equals("-")){
            coeff=-coeff;
        }


        if(matcher.group(3) == null){
            power=0;
        }
        else{
            if(matcher.group(4) == null){
                power=1;
            }
            else {
                String string=matcher.group(4);
                char value=string.charAt(1);
                power=Integer.parseInt(String.valueOf(value)) ;
            }
        }



        monomials.put(power,coeff);

    }

    @Override
    public String toString() {
        StringBuilder polynom = new StringBuilder();

        // Create a TreeMap with reverse order
        TreeMap<Integer, Double> sortedMonomials = new TreeMap<>(Collections.reverseOrder());
        sortedMonomials.putAll(monomials);

        for (Map.Entry<Integer, Double> entry : sortedMonomials.entrySet()) {
            if (entry.getValue() == 0) {
                continue; // Skip zero coefficients
            }

            // Append '+' for positive coefficients, except for the first term
            if (entry.getValue() > 0 && !polynom.isEmpty()) {
                polynom.append("+");
            }

            // Append the coefficient if it's not 1 or -1, or if the power is 0
            if (!entry.getValue().equals(1.0) && !entry.getValue().equals(-1.0) || entry.getKey() == 0) {
                polynom.append(entry.getValue());
            } else if (entry.getValue().equals(-1.0)) {
                polynom.append("-");
            }

            // Append 'x' and power if power is not 0
            if (entry.getKey() != 0) {
                polynom.append("x");
                if (entry.getKey() > 1) {
                    polynom.append("^").append(entry.getKey());
                }
            }
        }

        // Handle the case where the polynomial is 0
        if (polynom.isEmpty()) {
            return "0";
        }

        return polynom.toString();
    }


    public Map<Integer, Double> getMonomials() {
        return monomials;
    }

    public Integer getDegree(){
        int max=-1;

        for (Integer i : monomials.keySet()) {
            if (i > max){
                max=i;
            }
        }

        return  max;
    }

    public void updatePolynomial() {
        Iterator<Map.Entry<Integer, Double>> iterator = monomials.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Double> entry = iterator.next();
            if (entry.getValue() == 0) {
                iterator.remove();
            }
        }
    }

    public double getLeadCoeff(){
        return getMonomials().get(getDegree());
    }


}
