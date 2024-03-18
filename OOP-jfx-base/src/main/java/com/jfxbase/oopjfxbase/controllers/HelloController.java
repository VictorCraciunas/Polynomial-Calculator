package com.jfxbase.oopjfxbase.controllers;

import com.jfxbase.oopjfxbase.utils.Operations;
import com.jfxbase.oopjfxbase.utils.Polynomial;
import com.jfxbase.oopjfxbase.utils.enums.SCENE_IDENTIFIER;
import com.jfxbase.oopjfxbase.utils.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HelloController extends SceneController {
    @FXML
    private TextField polynom1;

    @FXML
    private TextField polynom2;

    @FXML
    private TextField result;

    private Integer changePoylnom=0;




    @FXML
    public void initialize(){


    }

    @FXML
    public void onAddition(){
        String stringPoly1=polynom1.getText();
        String stringPoly2=polynom2.getText();

        System.out.println(stringPoly1);
        System.out.println(stringPoly2);
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();

        if(polynomial1.isPolynomial(stringPoly1) && polynomial2.isPolynomial(stringPoly2)){
            polynomial1.createPolynomial(stringPoly1);
            polynomial2.createPolynomial(stringPoly2);
        }
        else{
            System.out.println("error");
        }

        Polynomial resultAddition=Operations.addition(polynomial1,polynomial2);
        if(resultAddition.getMonomials().isEmpty()){
            result.setText("0");
        }
        else {
            result.setText(resultAddition.toString());
        }
    }

    @FXML
    public void onDivision(){{
        String stringPoly1=polynom1.getText();
        String stringPoly2=polynom2.getText();

        System.out.println(stringPoly1);
        System.out.println(stringPoly2);
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();

        if(polynomial1.isPolynomial(stringPoly1) && polynomial2.isPolynomial(stringPoly2)){
            polynomial1.createPolynomial(stringPoly1);
            polynomial2.createPolynomial(stringPoly2);
        }
        else{
            System.out.println("error");
        }


        List<Polynomial> resultDivision= new ArrayList<>();
        resultDivision=Operations.divide(polynomial1,polynomial2);
        String stringResult="Cat: ";
        for (Polynomial polynomial : resultDivision) {
            stringResult=stringResult + polynomial +"rest: ";
        }
        result.setText(stringResult);
    }

    }
    @FXML
    public void onDerivation(){
        String stringPoly1=polynom1.getText();

        System.out.println(stringPoly1);
        Polynomial polynomial1=new Polynomial();

        if(polynomial1.isPolynomial(stringPoly1)){
            polynomial1.createPolynomial(stringPoly1);
        }
        else{
            System.out.println("error");
        }

        Polynomial resultDerivation=Operations.derivative(polynomial1);
        result.setText(resultDerivation.toString());


    }
    @FXML
    public void onIntegration(){
        String stringPoly1=polynom1.getText();

        System.out.println(stringPoly1);
        Polynomial polynomial1=new Polynomial();

        if(polynomial1.isPolynomial(stringPoly1)){
            polynomial1.createPolynomial(stringPoly1);
        }
        else{
            System.out.println("error");
        }

        Polynomial resultIntegration=Operations.integrate(polynomial1);
        result.setText(resultIntegration.toString());

    }
    @FXML
    public void onMultiplication(){
        String stringPoly1=polynom1.getText();
        String stringPoly2=polynom2.getText();

        System.out.println(stringPoly1);
        System.out.println(stringPoly2);
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();

        if(polynomial1.isPolynomial(stringPoly1) && polynomial2.isPolynomial(stringPoly2)){
            polynomial1.createPolynomial(stringPoly1);
            polynomial2.createPolynomial(stringPoly2);
        }
        else{
            System.out.println("error");
        }

        Polynomial resultMultiplication=Operations.multiplication(polynomial1,polynomial2);
        result.setText(resultMultiplication.toString());

    }

    @FXML
    public void onSubtraction(){

        String stringPoly1=polynom1.getText();
        String stringPoly2=polynom2.getText();

        System.out.println(stringPoly1);
        System.out.println(stringPoly2);
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();

        if(polynomial1.isPolynomial(stringPoly1) && polynomial2.isPolynomial(stringPoly2)){
            polynomial1.createPolynomial(stringPoly1);
            polynomial2.createPolynomial(stringPoly2);
        }
        else{
            System.out.println("error");
        }

        Polynomial resultSubstraction=Operations.subtraction(polynomial1,polynomial2);
        result.setText(resultSubstraction.toString());

    }

    @FXML
    public void onNumberPressed1(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "1";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "1";
            polynom2.setText(newText);
        }

    }

    @FXML
    public void onNumberPressed2(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "2";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "2";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed3(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "3";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "3";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed4(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "4";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "4";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed5(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "5";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "5";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed6(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "6";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "6";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed7(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "7";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "7";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed8(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "8";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "8";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed9(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "9";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "9";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onNumberPressed0(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "0";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "0";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void finishPolynom(){
        this.changePoylnom=1;
    }

    @FXML
    public void onxPressed(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "x";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "x";
            polynom2.setText(newText);
        }
    }
    @FXML
    public void onPlusPressed(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "+";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "+";
            polynom2.setText(newText);
        }
    }

    @FXML
    public void onMinusPressed(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "-";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "-";
            polynom2.setText(newText);
        }
    }

    @FXML
    public void onPowerPressed(){
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + "^";
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + "^";
            polynom2.setText(newText);
        }
    }

    @FXML
    public void deleteCharacter(){
        String copy;
        if(this.changePoylnom == 0){
            copy=polynom1.getText().substring(0, polynom1.getText().length()-1);
            this.polynom1.setText(copy);
        }
        else {
            copy=polynom2.getText().substring(0, polynom2.getText().length()-1);
            this.polynom2.setText(copy);
        }
    }

    @FXML
    public void clear(){
        polynom1.clear();
        polynom2.clear();
        result.clear();
        changePoylnom=0;
    }

}