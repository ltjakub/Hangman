package pl.hangman.models;

import pl.hangman.services.FileService;

import java.util.ArrayList;

public class Hangman {
    private String wordToGuess;
    private ArrayList<String> lettersAnswered = new ArrayList<>();
    private int wrongGuessCount;
    private String resultString = "";

    public Hangman() {
        this.wordToGuess = FileService.generateRandomWord();
        this.wrongGuessCount = -1;
        for (int i = 0; i < wordToGuess.length(); i++) {
            resultString += "_";
        }
        System.out.println(resultString);
    }

    public String getResultString() {
        return resultString;
    }

    public ArrayList<String> getLettersAnswered() {
        return lettersAnswered;
    }


    public int getWrongGuessCount() {
        return wrongGuessCount;
    }

    public void addLettersAnswered(String letter) {
        if (!lettersAnswered.contains(letter)) {
            this.lettersAnswered.add(letter);
            letterChecker(letter);
        }
    }

    private void letterChecker(String letter) {
        boolean wordContainsLetter = wordToGuess.contains(letter);
        if (wordContainsLetter) {
            int indx = wordToGuess.indexOf(letter);
            while (indx != -1) {

                this.resultString = addChar(this.resultString, letter, indx);
                indx = wordToGuess.indexOf(letter, indx + 1);
            }
            System.out.println(resultString);
        } else {
            this.wrongGuessCount++;
        }
    }


    private String addChar(String str, String ch, int position) {
        StringBuilder sb = new StringBuilder(str);
        sb.insert(position, ch);
        sb.delete(position + 1, position + 2);
        return sb.toString();
    }


}
