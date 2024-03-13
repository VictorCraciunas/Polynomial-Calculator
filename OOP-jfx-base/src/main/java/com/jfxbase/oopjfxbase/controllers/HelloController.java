package com.jfxbase.oopjfxbase.controllers;

import com.jfxbase.oopjfxbase.utils.Operations;
import com.jfxbase.oopjfxbase.utils.Polynomial;
import com.jfxbase.oopjfxbase.utils.enums.SCENE_IDENTIFIER;
import com.jfxbase.oopjfxbase.utils.SceneController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController extends SceneController {
    @FXML
    private TextField nameField;

    @FXML
    private Text helloPrompt;

    @FXML
    protected void onHelloButtonClick() {

        helloPrompt.setText(String.format("Hello %s", nameField.getText()));
    }

    @FXML
    protected void onGoToAnotherSceneClick(){
        this.changeScene(SCENE_IDENTIFIER.GOOD_BYE);
    }

    @FXML
    public void initialize(){
        Polynomial polynomial1=new Polynomial();
        Polynomial polynomial2=new Polynomial();

        if(polynomial1.isPolynomial("x^5+3x+1")){
            polynomial1.createPolynomial("x^5+3x+1");
            polynomial1.printMonomial();
        }
        else {
            System.out.println("Not polynomial1");
        }

        if(polynomial2.isPolynomial("2x^5-5x-1")){
            polynomial2.createPolynomial("2x^5-5x-1");
            polynomial2.printMonomial();
        }
        else {
            System.out.println("Not polynomial2");
        }


        Polynomial result= Operations.addPolynomials(polynomial1, polynomial2);
        System.out.println("Result+: ");
        result.printMonomial();


        Polynomial result2= Operations.substractPolynomials(polynomial1, polynomial2);
        System.out.println("\nResult-");
        result2.printMonomial();

    }


}