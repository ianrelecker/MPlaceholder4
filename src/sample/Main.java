// Ian Relecker
// ianrelecker@gmail.com
// www.ianrelecker.com
// Program that allows for the saving of location of watched video of mp4 files in Windows.
// version 0.1
//
// I would like to implement it to automatically launch the .mp4 from the "saved point".

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MPlaceholder4");

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


//

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
//

        vbox12.getChildren().addAll(labelP, hbox1, padd, labelL, hbox2, padd2, hbox3);
        vbox12.setPadding(new Insets(20,20,20,20));





        VBox saved = new VBox(20);
        showSave(saved);




        Scene layout1 = new Scene(vbox12, 300, 500);
        primaryStage.setScene(layout1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void showSave(VBox saved){
//        this will display the saved .mp4 from the csv
    }

    public static void save(String name, int location) throws FileNotFoundException {
        File saveFile = new File("saves.csv");
        PrintWriter output = new PrintWriter(saveFile);
        output.print(name);
        output.print(location);
        output.println("\b");
        output.close();
    }
}
