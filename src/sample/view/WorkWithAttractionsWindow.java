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
import sample.impl.ManageAttractionSalesImpl;
import sample.impl.ManageAttractionsImpl;

public class WorkWithAttractionsWindow {

    public Controller controller;
    public WorkWithMainAlleyWindow workWithMainAlleyWindow;
    public ViewAttractionWindow viewAttractionWindow;
    public ManageAttractionSalesImpl manageAttractionSales;
    public ManageAttractionsImpl manageAttractions;

    public void show() {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20, 20, 50, 20));

        Label attractionLabel = new Label("Выберите аттракцион:");


        ComboBox attractionsComboBox = new ComboBox();
        attractionsComboBox.setMinWidth(200);
        for (Attraction attraction : controller.park.getAttractions()) {
            attractionsComboBox.getItems().addAll(attraction.getName());
        }

        Button viewAttractionButton = new Button("Просмотреть");
        viewAttractionButton.setMinWidth(200);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent v)
            {
                viewAttractionWindow.show(attractionsComboBox.getValue().toString());
            }
        };
        viewAttractionButton.setOnAction(event);

        Button buyAttractionButton = new Button("Купить");
        buyAttractionButton.setMinWidth(100);

        Button removeAttractionButton = new Button("Удалить");
        removeAttractionButton.setMinWidth(100);

        Button mainAlleyButton = new Button("Главная Аллея");
        mainAlleyButton.setMinWidth(200);

        EventHandler<ActionEvent> alleyEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent m)
            {
                workWithMainAlleyWindow.show();
            }
        };
        mainAlleyButton.setOnAction(alleyEvent);


        VBox buttons = new VBox(mainAlleyButton, attractionLabel, attractionsComboBox, viewAttractionButton,
                new HBox(removeAttractionButton, buyAttractionButton));

        buttons.setSpacing(10);
        root.setCenter(buttons);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Атракционы");
        primaryStage.setScene(new Scene(root, 240, 300));
        primaryStage.show();
    }
}
