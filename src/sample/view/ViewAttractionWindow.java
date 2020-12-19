package sample.view;

import javafx.beans.property.ObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Attraction;
import sample.Controller;
import sample.Visitor;
import sample.impl.ManageAttractionUsageImpl;

public class ViewAttractionWindow {
    public Controller controller;
    public ManageAttractionUsageImpl manageAttractionUsage;

    public void show(String attractionName){
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(70, 30, 50, 50));
        
        Attraction currentAttraction = null;
        for (Attraction attraction : controller.park.getAttractions()) {
            if (attraction.name.equals(attractionName)) {
                currentAttraction = attraction;
                break;
            }
        }
        
        Label attractionLabel = new Label("Название аттракциона: " + currentAttraction.name);

        Label queueLabel = new Label("Очередь: ");
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

        table.setItems(currentAttraction.getQueueVisitorsOnAttraction());
        table.getColumns().addAll(idCol, salaryCol);

        Label timeLabel = new Label("Время работы: " + currentAttraction.getPastSessionTime() + "/" + currentAttraction.getSessionTime());
        Label seatLabel = new Label("Количество мест: " + Integer.toString(currentAttraction.getVisitorsOnAttraction().size()) + "/" + Integer.toString(currentAttraction.getNumberOfSeats()));

        Label onRideLabel = new Label("Катающиеся: ");
        TableView<Visitor> visitorsOnRideTable = new TableView<>();
        table.setMinHeight(150);
        table.setMinWidth(150);
        //TableColumn idCol = new TableColumn("id");
        //idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id"));

    //    TableColumn salaryCol = new TableColumn("salary");
      //  salaryCol.setMinWidth(100);
        salaryCol.setCellValueFactory(
                new PropertyValueFactory<>("salary"));

        visitorsOnRideTable.setItems(currentAttraction.getVisitorsOnAttraction());
        visitorsOnRideTable.getColumns().addAll(idCol, salaryCol);


        Button buyTicketButton = new Button("Активировать:");
        buyTicketButton.setMinWidth(300);
        buyTicketButton.setMinHeight(50);

        VBox objects = new VBox(attractionLabel, timeLabel, seatLabel, table, onRideLabel, visitorsOnRideTable, buyTicketButton);
        root.setCenter(objects);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Просмотр аттракциона");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }
}
