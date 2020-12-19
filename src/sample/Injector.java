package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.impl.*;
import sample.view.*;

public class Injector {
    
    Controller controller;
    
    public void create_park_management() {
        Visitor visitor = new Visitor(312324, 43);
        ObservableList<Visitor> visitors = FXCollections.observableArrayList();
        visitors.add(visitor);

        Attraction attraction = new Attraction("XXX", 213, visitors, 32, 432);
        attraction.setQueueVisitorsOnAttraction(visitors);
        attraction.setVisitorsOnAttraction(visitors);
        ObservableList<Attraction> attractions = FXCollections.observableArrayList();
        attractions.add(attraction);

        Park park = new Park(120321, 32, visitors);
        park.setAttractions(attractions);
        park.setVisitors(visitors);

        controller = new Controller();
        controller.park = park;

    }

    public void createUI() {
        StartWindow startWindow = new StartWindow();
        
        ObjectSelectionWindow objectSelectionWindow = new ObjectSelectionWindow();
        objectSelectionWindow.controller = controller;
        startWindow.objectSelectionWindow = objectSelectionWindow;

        WorkWithVisitorsWindow workWithVisitorsWindow = new WorkWithVisitorsWindow();
        workWithVisitorsWindow.controller = controller;
        objectSelectionWindow.workWithVisitorsWindow = workWithVisitorsWindow;

        WorkWithAttractionsWindow workWithAttractionsWindow = new WorkWithAttractionsWindow();
        workWithAttractionsWindow.controller = controller;
        objectSelectionWindow.workWithAttractionsWindow = workWithAttractionsWindow;

        WorkWithMainAlleyWindow workWithMainAlleyWindow = new WorkWithMainAlleyWindow();
        workWithMainAlleyWindow.controller = controller;
        workWithAttractionsWindow.workWithMainAlleyWindow = workWithMainAlleyWindow;

        ViewAttractionWindow viewAttractionWindow = new ViewAttractionWindow();
        viewAttractionWindow.controller = controller;
        workWithMainAlleyWindow.viewAttractionWindow = viewAttractionWindow;
        workWithAttractionsWindow.viewAttractionWindow = viewAttractionWindow;

        ManageAttractionUsageImpl manageAttractionUsage = new ManageAttractionUsageImpl();
        ManageAttractionsImpl manageAttractions = new ManageAttractionsImpl();
        ManageAttractionSalesImpl manageAttractionSales = new ManageAttractionSalesImpl();
        ManageParkImpl managePark = new ManageParkImpl();
        ManageMainAlleyImpl manageMainAlley = new ManageMainAlleyImpl();
        ManageTicketSalesImpl manageTicketSales = new ManageTicketSalesImpl();
        ManageVisitorsImpl manageVisitors = new ManageVisitorsImpl();


        workWithMainAlleyWindow.manageAttractions = manageAttractions;
        workWithMainAlleyWindow.manageMainAlley = manageMainAlley;
        workWithMainAlleyWindow.manageVisitors = manageVisitors;

        workWithVisitorsWindow.manageTicketSales = manageTicketSales;
        workWithVisitorsWindow.manageVisitors = manageVisitors;

        workWithAttractionsWindow.manageAttractions = manageAttractions;
        workWithAttractionsWindow.manageAttractionSales = manageAttractionSales;

        objectSelectionWindow.manageAttractions = manageAttractions;
        objectSelectionWindow.manageVisitors = manageVisitors;
        objectSelectionWindow.managePark = managePark;

        viewAttractionWindow.manageAttractionUsage = manageAttractionUsage;

        startWindow.show();
    }
}
