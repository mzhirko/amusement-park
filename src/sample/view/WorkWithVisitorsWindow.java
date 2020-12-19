package sample.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Controller;
import sample.Visitor;
import sample.impl.ManageTicketSalesImpl;
import sample.impl.ManageVisitorsImpl;

public class WorkWithVisitorsWindow {

    public Controller controller;
    public ManageTicketSalesImpl manageTicketSales;
    public ManageVisitorsImpl manageVisitors;

    public void show(){

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(70, 30, 50, 50));

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

        Button addVisitorButton = new Button("Добавить");
        addVisitorButton.setMinWidth(150);
        addVisitorButton.setMinHeight(50);

        Button deleteVisitorButton = new Button("Удалить");
        deleteVisitorButton.setMinWidth(150);
        deleteVisitorButton.setMinHeight(50);

        Button buyTicketButton = new Button("Купить билет");
        buyTicketButton.setMinWidth(300);
        buyTicketButton.setMinHeight(50);

        VBox objects = new VBox(table, new HBox(addVisitorButton, deleteVisitorButton), buyTicketButton);
        root.setCenter(objects);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Посетители");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
