package com.jfxbase.oopjfxbase.utils;

import java.util.HashMap;
import java.util.Map;
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

    public String printMonomial(){
        String polynom="Result: ";
        for (Map.Entry<Integer, Double> entry : monomials.entrySet()) {
            if(entry!= null && entry.getValue() != 0) {
                if(entry.getKey() == 0){
                    polynom=polynom + entry.getValue();
                    System.out.println(entry.getValue());
                }
                else if(entry.getKey() == 1){
                    polynom=polynom + "+" + entry.getValue() + "x";
                    System.out.println(entry.getValue() + "x");
                }
                else if(entry.getValue() > 1){
                    polynom=polynom +  "+" + entry.getValue() +"x^" +entry.getKey();
                    System.out.println(entry.getValue() + "x^" + entry.getKey());
                }
                else {
                    polynom=polynom + entry.getValue() +"x^" +entry.getKey();
                }
            }
        }
        return polynom;
    }

    public Map<Integer, Double> getMonomials() {
        return monomials;
    }
}
