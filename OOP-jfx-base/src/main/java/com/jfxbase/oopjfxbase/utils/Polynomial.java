package com.jfxbase.oopjfxbase.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    //This map is going to be our polynomial
    Map<Integer,Double> monomials=new HashMap<>(); // key is the power, value is the coefficient


    //Check if the input is polynomial
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

        //regex with the form +-ax^b
        String monomial="([+-])?\\b([1-9]\\d*)?(x(\\^\\d+)?)?";

        Pattern pattern=Pattern.compile(monomial);
        Matcher matcher=pattern.matcher(polynomial);

        String match;


        //We create the polynomial by dividing the string into matches(monomials).
        // Each match is going to have groups, which are a part of the regex from the monomial
        while(matcher.find()){
            match= matcher.group();
            if(!match.isEmpty()){
                insertMonomial(matcher);
            }
        }

    }

    private void insertMonomial(Matcher matcher){

        //We create the coefficient and the power from the groups
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


        //We add them to our polynomial
        monomials.put(power,coeff);

    }

    //We use this method in order to print the polynomial
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


    //the highest power
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
                iterator.remove(); // we remove the elements with coefficient 0
            }
        }
    }

    public double getLeadCoeff(){
        return getMonomials().get(getDegree());
    } //the term with the highest power


}
