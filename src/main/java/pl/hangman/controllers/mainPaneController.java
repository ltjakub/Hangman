package pl.hangman.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import pl.hangman.models.Hangman;

import java.util.ArrayList;

public class mainPaneController {

    @FXML
    private TextField inputTextField;

    @FXML
    private Line line1;

    @FXML
    private Line line10;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Circle line5;

    @FXML
    private Line line6;

    @FXML
    private Line line7;

    @FXML
    private Line line8;

    @FXML
    private Line line9;

    @FXML
    private Button submitButton;

    @FXML
    private Label usedLettersLabel;

    @FXML
    private Label wordLabel;
    @FXML
    private Button newGameButton;
    @FXML
    private Label resultLabel;
    Hangman hangman = new Hangman();

    public void initialize() {
        Shape[] lines = {line1, line2, line3, line4, line5, line6, line7, line8, line9, line10};
        submitButton.setOnAction(actionEvent -> submitGuess(lines));
        newGameButton.setOnAction(actionEvent -> setNewGame(lines));
    }

    private void submitGuess(Shape[] lines) {
        if (!inputTextField.getText().equals("") && inputTextField.getText().length() == 1 && hangman.getWrongGuessCount() < 9) {
            hangman.addLettersAnswered(inputTextField.getText().toUpperCase());
            inputTextField.clear();
            displayResults(lines);
        }
    }

    private void displayResults(Shape[] lines) {
        usedLettersLabel.setText(hangman.getLettersAnswered().toString());
        wordLabel.setText(hangman.getResultString());
        if(hangman.getWrongGuessCount() >= 0) {
            lines[hangman.getWrongGuessCount()].setOpacity(1);
        }
        if(hangman.getWrongGuessCount() == lines.length - 1) {
            resultLabel.setText("You lost!");
        } else if(!hangman.getResultString().contains("_")) {
            resultLabel.setText("You won!");
        }
    }
    private void setNewGame(Shape[] lines) {
        hangman = new Hangman();
        resultLabel.setText("");
        inputTextField.clear();
        for (Shape line : lines) {
            line.setOpacity(0);
        }

        displayResults(lines);
    }
}
