package com.jfxbase.oopjfxbase.controllers;

import com.jfxbase.oopjfxbase.AppLogic.Operations;
import com.jfxbase.oopjfxbase.AppLogic.Polynomial;
import com.jfxbase.oopjfxbase.utils.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class CalculatorController extends SceneController {
    @FXML
    private TextField polynom1;

    @FXML
    private TextField polynom2;

    @FXML
    private TextField result;

    private Integer changePoylnom=0;

    private Polynomial polynomial1=new Polynomial();
    private Polynomial polynomial2=new Polynomial();

    @FXML
    public void initialize() {
        // Initial highlight setup
        if (this.changePoylnom == 0) {
            polynom1.getStyleClass().add("text-field-highlight");
        } else {
            polynom2.getStyleClass().add("text-field-highlight");
        }
    }


    //Actions for the buttons 0-9, x, +, -, ^
    @FXML
    public void onButtonPressed(ActionEvent event) {
        Button button = (Button) event.getSource();
        String number = button.getText();

        // we add the character to the current polynomial
        updatePolynomialText(number);
    }


    //We build the polynomial string
    private void updatePolynomialText(String character) {
        if(this.changePoylnom == 0)
        {
            String currentText = polynom1.getText();
            String newText = currentText + character;
            polynom1.setText(newText);
        }
        else {
            String currentText = polynom2.getText();
            String newText = currentText + character;
            polynom2.setText(newText);
        }
    }


    @FXML
    public void onAddition(){
        if (!preparePolynomials()) {
            return;
        }

        Polynomial resultAddition=Operations.addition(polynomial1,polynomial2);
        result.setText(resultAddition.toString());

    }

    @FXML
    public void onDivision() {

        if(polynom2.getText().equals("0")){
            showError();
            return;
        }
        if (!preparePolynomials()) {
            return;
        }

        List<Polynomial> resultDivision = Operations.divide(polynomial1, polynomial2);


        String stringResult = "Quotient: " + resultDivision.get(0).toString() +
                " Remainder: " + resultDivision.get(1).toString();

        result.setText(stringResult);
    }

    @FXML
    public void onDerivation(){
        String stringPoly1=polynom1.getText();


        if(polynomial1.isPolynomial(stringPoly1)){
            polynomial1.createPolynomial(stringPoly1);
        }
        else{
            showError();
        }

        Polynomial resultDerivation=Operations.derivative(polynomial1);
        result.setText(resultDerivation.toString());


    }
    @FXML
    public void onIntegration(){
        String stringPoly1=polynom1.getText();

        if(polynomial1.isPolynomial(stringPoly1)){
            polynomial1.createPolynomial(stringPoly1);
        }
        else{
            showError();
        }

        Polynomial resultIntegration=Operations.integrate(polynomial1);
        result.setText(resultIntegration.toString());

    }
    @FXML
    public void onMultiplication(){
        if (!preparePolynomials()) {
            return;
        }


        Polynomial resultMultiplication=Operations.multiplication(polynomial1,polynomial2);
        result.setText(resultMultiplication.toString());

    }

    @FXML
    public void onSubtraction(){
        if (!preparePolynomials()) {
            return;
        }


        Polynomial resultSubtraction=Operations.subtraction(polynomial1,polynomial2);
        result.setText(resultSubtraction.toString());

    }

    //We switch between the polynomials from the inputs using switch button
    @FXML
    public void changePolynom(){
        if(this.changePoylnom == 0){
            this.changePoylnom=1;
            polynom1.getStyleClass().remove("text-field-highlight");
            polynom2.getStyleClass().add("text-field-highlight");
        }
        else {
            this.changePoylnom=0;
            polynom2.getStyleClass().remove("text-field-highlight");
            polynom1.getStyleClass().add("text-field-highlight");
        }
    }

    //We delete character from the current polynomial
    @FXML
    public void deleteCharacter(){
        String copy;
        if(this.changePoylnom == 0){
            if (!polynom1.getText().isEmpty()) {
                copy=polynom1.getText().substring(0, polynom1.getText().length()-1);
                this.polynom1.setText(copy);
            }
        }
        else {
            if (!polynom2.getText().isEmpty()) {
                copy=polynom2.getText().substring(0, polynom2.getText().length()-1);
                this.polynom2.setText(copy);
            }
        }
    }

    //We clear the interface using clear button
    @FXML
    public void clear(){
        polynom1.clear();
        polynom2.clear();
        result.clear();
        changePoylnom=0;
        polynomial1.getMonomials().clear();
        polynomial2.getMonomials().clear();
        polynom1.getStyleClass().add("text-field-highlight");
        polynom2.getStyleClass().remove("text-field-highlight");
    }

    //Errors for the incorrect inputs
    public void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Error inputs");
        alert.show ();
    }

    //We check if the user inserted a correct polynomial format and if the textfields aren't empty
    private boolean preparePolynomials() {
        String stringPoly1 = polynom1.getText();
        String stringPoly2 = polynom2.getText();

        if (!isEmptyPolynomials() && polynomial1.isPolynomial(stringPoly1) && polynomial2.isPolynomial(stringPoly2)) {
            polynomial1.createPolynomial(stringPoly1);
            polynomial2.createPolynomial(stringPoly2);
            return true;
        } else {
            showError();
            return false;
        }
    }

    public boolean isEmptyPolynomials(){
        if(polynom1.getText().isEmpty() || polynom2.getText().isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

}