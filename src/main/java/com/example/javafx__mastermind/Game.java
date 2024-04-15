package com.example.javafx__mastermind;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;


public class Game {
    private final int MAX_ATTEMPTS = 10;
    private final int CODE_LENGTH = 4;
    private final int NUM_SYMBOLS = 10;

    private List<String> symbols;
    private String secretCode;
    private List<Attempt> attempts;
    private int currentAttempt;

    private BorderPane root;
    private VBox attemptsBox;
    private HBox currentAttemptBox;
    private Button resetButton;

    public Game() {
        initGameData();
        createGameUI();
    }

    private void initGameData() {
        symbols = Arrays.asList("red", "green", "blue", "yellow", "purple", "orange", "pink", "brown");
        generateSecretCode();
        attempts = new ArrayList<>();
        currentAttempt = 0;
    }

    private void generateSecretCode() {
        List<String> code = new ArrayList<>(symbols);
        Collections.shuffle(code);
        secretCode = String.join("", code.subList(0, CODE_LENGTH));
    }

    private void createGameUI() {
        root = new BorderPane();
        // Affichage des tentatives
        attemptsBox = new VBox(10);
        root.setCenter(attemptsBox);

        // Saisie de la tentative courante
        currentAttemptBox = new HBox(10);
        root.setBottom(currentAttemptBox);

        // Bouton de la réinitialisation
        resetButton = new Button("Nouvelle Partie");
        resetButton.setOnAction(e -> resetGame());
        root.setCenter(resetButton);
    }
    private void resetGame() {
        initGameData();
        updateAttemptsUI();
        updateCurrentAttemptUI();
    }

    private void updateCurrentAttemptUI() {
        currentAttemptBox.getChildren().clear();
        for (int i = 0; i < CODE_LENGTH; i++) {
            currentAttemptBox.getChildren().add(new Label("_"));
        }
    }

    private void updateAttemptsUI() {
        attemptsBox.getChildren().clear();
        for (Attempt attempt : attempts) {
            attemptsBox.getChildren().add(new Label(attempt.toString()));
        }
    }

    public void makeAttempt(String attempt) {
        // Gestion de la saisie: devrais-je utiliser une methode?
        if (attempt.length() != CODE_LENGTH) {
            return;
        }

        int goodPlaced = 0;
        int goodPlacedButMisplaced = 0;

        // Vérification de la tentative
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (attempt.charAt(i) == secretCode.charAt(i)) {
                goodPlaced++;
            } else if (secretCode.contains(String.valueOf(attempt.charAt(i)))) {
                goodPlacedButMisplaced++;
            }
        }

        Attempt newAttempt = new Attempt(attempt, goodPlaced, goodPlacedButMisplaced);
        attempts.add(newAttempt);
        currentAttempt++;
        // Mise à jour de l'interface
        updateAttemptsUI();
        updateCurrentAttemptUI();

        if (goodPlaced == CODE_LENGTH) {
            // En cas de victoire
            showWinMessage();
            resetGame();
        } else if (currentAttempt == MAX_ATTEMPTS) {
            // Défaite
            showLoseMessage();
            resetGame();
        }
    }

    private void showLoseMessage() {
    }

    private void showWinMessage() {
    }

    public Parent getRoot() {
        return root;
    }
}
