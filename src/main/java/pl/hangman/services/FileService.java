package pl.hangman.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FileService {
    private static List<String> wordsList;

    public static void createWordsList() {
        try (
                FileReader fileReader = new FileReader("src/main/resources/words/words.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
           wordsList = bufferedReader.lines().toList();

        } catch (IOException e) {
            System.err.println("File not found");
        }
    }
    public static String generateRandomWord() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, wordsList.size() + 1);
        return wordsList.get(randomNum).toUpperCase();
    }
}
