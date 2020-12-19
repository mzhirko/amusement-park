package sample.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Attraction;
import sample.Controller;
import sample.Visitor;
import sample.impl.ManageAttractionsImpl;
import sample.impl.ManageMainAlleyImpl;
import sample.impl.ManageVisitorsImpl;

public class WorkWithMainAlleyWindow {

    public Controller controller;
    public ViewAttractionWindow viewAttractionWindow;
    public ManageMainAlleyImpl manageMainAlley;
    public ManageAttractionsImpl manageAttractions;
    public ManageVisitorsImpl manageVisitors;

    public void show(){

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(70, 30, 50, 50));

        Label visitorLabel = new Label("Посетители:");
        TableView<Visitor> table = new TableView<>();
        table.setMinHeight(150);
        table.setMinWidth(150);
        TableColumn idCol = new TableColumn("id");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        TableColumn salaryCol = new TableColumn("salary");
        salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(
                new PropertyValueFactory<>("salary"));

        table.setItems(controller.getPark().visitors);
        table.getColumns().addAll(idCol, salaryCol);

        Label attractionLabel = new Label("Аттракционы:");
        ComboBox attractionsComboBox = new ComboBox();
        attractionsComboBox.setMinWidth(300);
        for (Attraction attraction : controller.park.getAttractions()) {
            attractionsComboBox.getItems().addAll(attraction.getName());
        }

        Button viewAttractionButton = new Button("Перейти на аттракцион");
        viewAttractionButton.setMinWidth(150);
        viewAttractionButton.setMinHeight(50);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent v)
            {
                viewAttractionWindow.show(attractionsComboBox.getValue().toString());
            }
        };
        viewAttractionButton.setOnAction(event);

        Button deleteFromParkButton = new Button("Удалить из парка");
        deleteFromParkButton.setMinWidth(150);
        deleteFromParkButton.setMinHeight(50);


        VBox objects = new VBox(new VBox(visitorLabel, table), new VBox(attractionLabel, attractionsComboBox), new HBox(viewAttractionButton, deleteFromParkButton));
        root.setCenter(objects);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Главная Аллея");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

}
