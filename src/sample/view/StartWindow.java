package sample.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Controller;

public class StartWindow {

    public ObjectSelectionWindow objectSelectionWindow;

    public void show() {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(70, 30, 50, 70));

        Button startButton = new Button("СТАРТ");
        startButton.setMinWidth(200);
        startButton.setMinHeight(90);

       // Label l = new Label("button not selected");


        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                objectSelectionWindow.show();
            }
        };
        startButton.setOnAction(event);

        VBox buttons = new VBox(startButton);

        root.setCenter(buttons);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Симуляция Парка Аттракционов");
        primaryStage.setScene(new Scene(root, 350, 300));
        primaryStage.show();
    }

}