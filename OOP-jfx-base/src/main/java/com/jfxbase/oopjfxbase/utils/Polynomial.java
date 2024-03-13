package com.jfxbase.oopjfxbase.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {

    Map<Integer,Integer> monomials=new HashMap<>();


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
            System.out.println(match);
            if(!match.isEmpty()){
                insertMonomial(matcher);
            }
        }

    }

    private void insertMonomial(Matcher matcher){
        int coeff;
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


        if(matcher.group(4) == null){
            power=0;
        }
        else if(matcher.group(4).equals("^0")){
            power=0;
        }
        else if (matcher.group(4).equals("^1")){
            power=1;
        }
        else {
            power=Integer.parseInt(String.valueOf(2)) ;
        }

        monomials.put(power,coeff);

    }

    public void printMonomial(){
        for (Map.Entry<Integer, Integer> entry : monomials.entrySet()) {
            if(entry!=null) {
                System.out.println(entry.getValue() + "x^" +entry.getKey());
            }
        }
    }
}
