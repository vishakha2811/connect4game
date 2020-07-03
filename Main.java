package com.internshala.connect4Game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main<addAll> extends Application {
   private Controller controller;
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();
        controller= loader.getController();
        controller.createPlayground();
        MenuBar menuBar =createMenu();
        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        Scene scene= new Scene(rootGridPane);
        primaryStage.setTitle("Connect Four");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private MenuBar createMenu() {
        //File Menu
        Menu fileMenu = new Menu("File");
        //New game
        MenuItem newGame = new MenuItem("New game");
        newGame.setOnAction(event -> resetGame());
        //reset game
        MenuItem resetGame = new MenuItem("Reset game");
        resetGame.setOnAction(event -> resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        //quit game
        MenuItem quitGame = new MenuItem("Quit game");
        quitGame.setOnAction(event -> quitGame());

        fileMenu.getItems().addAll(newGame,resetGame,separatorMenuItem,quitGame);
        //Help Menu
        Menu helpMenu = new Menu("Help");
        //about Connect4
        MenuItem aboutGame = new MenuItem("About Connect4");
        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separator = new SeparatorMenuItem();
        //About me
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutGame,separator,aboutMe);
        //menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Developer");
        alert.setHeaderText("Vishakha");
        alert.setContentText("This is my first game developed by me with the help of java. I like to play connect4 game with my dear ones to keep my mind fresh.");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect4");
        alert.setHeaderText("How To Play?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, occupying the next available space within the column. The objective of the game is to be the first to form a horizontal, vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. The first player can always win by playing the right moves.");
        alert.show();
    }

    private void quitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        controller.resetGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
