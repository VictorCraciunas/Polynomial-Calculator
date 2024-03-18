package com.jfxbase.oopjfxbase.utils;

import java.util.HashMap;
import java.util.Iterator;
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

    @Override
    public String toString(){
        String polynom="";
        for (Map.Entry<Integer, Double> entry : monomials.entrySet()) {
            if(entry!= null && entry.getValue() != 0) {
                if(entry.getKey() == 0){
                    polynom=polynom + entry.getValue();
                }
                else if(entry.getValue() > 0 && entry.getKey() > 1 && entry.getValue() != 1){
                    polynom=polynom +  "+" + entry.getValue() +"x^" +entry.getKey();
                }
                else if(entry.getKey() == 1 && entry.getValue() >= 0){
                    polynom=polynom + "+" + entry.getValue() + "x";
                }
                else if(entry.getKey() == 1 && entry.getValue() < 0){
                    polynom=polynom + "+" + entry.getValue() + "x";
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
