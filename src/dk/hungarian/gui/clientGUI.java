package dk.hungarian.gui;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class clientGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("clientGUI.fxml"));
        primaryStage.setTitle("Socket client GUI");
        primaryStage.setScene(new Scene(root, 640, 460));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

