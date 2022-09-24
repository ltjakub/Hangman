module Wordle {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    exports pl.hangman.main;
    opens pl.hangman.controllers;
}