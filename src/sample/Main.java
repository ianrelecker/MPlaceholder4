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
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
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
