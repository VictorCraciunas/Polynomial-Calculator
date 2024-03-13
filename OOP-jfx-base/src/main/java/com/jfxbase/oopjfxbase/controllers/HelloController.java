package com.jfxbase.oopjfxbase.controllers;

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
        Polynomial polynomial=new Polynomial();

        if(polynomial.isPolynomial("-x^2+3xx")){
            polynomial.createPolynomial("-x^2+3xx");
            polynomial.printMonomial();
        }
        else {
            System.out.println("Not polynomial");
        }

    }


}