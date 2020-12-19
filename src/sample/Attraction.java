package sample;

import javafx.collections.ObservableList;

public class Attraction {
    public String name;
    public int attractionPrice;
    public ObservableList<Visitor> queueVisitorsOnAttraction;
    public ObservableList<Visitor> visitorsOnAttraction;
    public ObservableList<Visitor> peoples;
    private int numberOfSeats;
    private int sessionTime;
    private int pastSessionTime;

    public Attraction(String name, int attractionPrice, ObservableList<Visitor> peoples, int numberOfSeats, int sessionTime) {
        this.name = name;
        this.attractionPrice = attractionPrice;
        this.peoples = peoples;
        this.numberOfSeats = numberOfSeats;
        this.sessionTime = sessionTime;
    }

    public int getAttractionPrice() {
        return attractionPrice;
    }

    public void setAttractionPrice(int attractionPrice) {
        this.attractionPrice = attractionPrice;
    }

    public ObservableList<Visitor> getQueueVisitorsOnAttraction() {
        return queueVisitorsOnAttraction;
    }

    public void setQueueVisitorsOnAttraction(ObservableList<Visitor> queueVisitorsOnAttraction) {
        this.queueVisitorsOnAttraction = queueVisitorsOnAttraction;
    }

    public ObservableList<Visitor> getVisitorsOnAttraction() {
        return visitorsOnAttraction;
    }

    public void setVisitorsOnAttraction(ObservableList<Visitor> visitorsOnAttraction) {
        this.visitorsOnAttraction = visitorsOnAttraction;
    }

    public ObservableList<Visitor> getPeoples() {
        return peoples;
    }

    public void setPeoples(ObservableList<Visitor> peoples) {
        this.peoples = peoples;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getPastSessionTime() {
        return pastSessionTime;
    }

    public void setPastSessionTime(int pastSessionTime) {
        this.pastSessionTime = pastSessionTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String attraction(String name, int price) {

        return "text";
    }

    private void deleteVisitorFromQueue() {

    }


}
