// Ian Relecker
// ianrelecker@gmail.com
// www.ianrelecker.com
// Program that allows for the saving of location of watched video of mp4 files in Windows.
// version 0.2
//
// I would like to implement it to automatically launch the .mp4 from the "saved point".


//ISSUES
//saves not updating on GUI
//saves not displaying correctly

package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MPlaceholder4");
        HBox saved = new HBox(20);

//
        TextField userInputPath = new TextField();
        Label labelP = new Label("Path of .mp4");
        labelP.setPadding(new Insets(0,0,0,56));


//
        TextField userInputLocation = new TextField();
        Label labelL = new Label("Time into .mp4");
        labelL.setPadding(new Insets(0,0,0,56));

//
        Button enter = new Button("Save");
        enter.setOnAction(e -> {
            try {
                save(userInputPath.getText(), userInputLocation.getText());
            } catch (IOException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            saved.getChildren();
        });


// Layout stuff
// myGUIsucks.txt
        VBox vbox12 = new VBox(0);
        HBox hbox1 = new HBox(20);
        hbox1.getChildren().addAll(userInputPath);
        hbox1.setAlignment(Pos.CENTER);
        HBox hbox2 = new HBox(20);
        hbox2.getChildren().addAll(userInputLocation);
        hbox2.setAlignment(Pos.CENTER);
        HBox hbox3 = new HBox(20);

        hbox3.getChildren().addAll(enter);
        hbox3.setAlignment(Pos.CENTER);
        Label padd = new Label(" ");
        Label padd2 = new Label("");


// layout for showing the saved items
        try {
            showSave(saved);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


// final layout
        vbox12.getChildren().addAll(labelP, hbox1, padd, labelL, hbox2, padd2, hbox3, saved);
        vbox12.setPadding(new Insets(20,20,20,20));

        Scene layout1 = new Scene(vbox12, 300, 500);
        primaryStage.setScene(layout1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void showSave(HBox saved) throws FileNotFoundException, NoSuchElementException {
        File saveFile = new File("saves.csv");
        Scanner fileIn = new Scanner(saveFile);
        int amtLines = 1;
        int exit = 0;
        while (exit == 0){
            try{
            if(fileIn.nextLine() != null){
                exit++;
            }
            amtLines++;
            }catch (NoSuchElementException p){
                p.getStackTrace();
                break;

            }
        }
//
        Scanner fileIn1 = new Scanner(saveFile);
        String[] paths = new String[amtLines];
        String[] locations = new String[amtLines];
        int counter = 0;
        while (counter < amtLines){
            try {
                if (counter % 2 == 0) {
                    paths[counter] = fileIn1.nextLine();

                } else {
                    locations[counter] = fileIn1.nextLine();
                }
                counter++;
            }catch(NoSuchElementException o){
                o.getStackTrace();
                break;
            }
        }
//
        VBox pathsBox = new VBox(0);
        VBox locateBox = new VBox(0);
        for(int i=0; i<paths.length; i++){
            Label tempLabel = new Label(paths[i]);
            pathsBox.getChildren().add(i, tempLabel);
        }
        for(int i=0; i<locations.length; i++){
            Label tempLabel2 = new Label(locations[i]);
            locateBox.getChildren().add(i, tempLabel2);
        }
        pathsBox.setAlignment(Pos.CENTER);
        locateBox.setAlignment(Pos.CENTER);
        saved.getChildren().addAll(pathsBox, locateBox);
    }

    public void save(String path, String location) throws IOException {
        File saveFile = new File("saves.csv");
        FileWriter output = new FileWriter(saveFile, true);
        output.write(path + "\n");
        output.append(location).append("\n");
        output.close();
    }
}
