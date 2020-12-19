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
import sample.impl.ManageAttractionsImpl;
import sample.impl.ManageParkImpl;
import sample.impl.ManageVisitorsImpl;

public class ObjectSelectionWindow {

    public WorkWithVisitorsWindow workWithVisitorsWindow;
    public WorkWithAttractionsWindow workWithAttractionsWindow;
    public Controller controller;
    public ManageParkImpl managePark;
    public ManageVisitorsImpl manageVisitors;
    public ManageAttractionsImpl manageAttractions;

    public void show() {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(70, 30, 50, 70));

        Button visitorButton = new Button("Посетитель");
        visitorButton.setMinWidth(150);
        visitorButton.setMinHeight(50);

        Button attractionButton = new Button("Аттракцион");
        attractionButton.setMinWidth(150);
        attractionButton.setMinHeight(50);



        EventHandler<ActionEvent> visitorEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                workWithVisitorsWindow.show();
            }
        };
        visitorButton.setOnAction(visitorEvent);

        EventHandler<ActionEvent> attractionEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent a)
            {
                workWithAttractionsWindow.show();
            }
        };
        attractionButton.setOnAction(attractionEvent);

        VBox buttons = new VBox(visitorButton, attractionButton);

        root.setCenter(buttons);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Симуляция Парка Аттракционов");
        primaryStage.setScene(new Scene(root, 350, 300));
        primaryStage.show();
    }

}
