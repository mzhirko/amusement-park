package sample;

import javafx.collections.ObservableList;

public class Park {
    public int budget;
    public int ticketPrice;
    public ObservableList<Visitor> visitorsOnAlley;
    public ObservableList<Attraction> attractions;
    public ObservableList<Visitor> visitors;

    public Park(int budget, int ticketPrice, ObservableList<Visitor> visitors) {
        this.budget = budget;
        this.ticketPrice = ticketPrice;
        this.visitorsOnAlley = visitors;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public ObservableList<Visitor> getVisitorsOnAlley() {
        return visitorsOnAlley;
    }

    public void setVisitorsOnAlley(ObservableList<Visitor> visitorsOnAlley) {
        this.visitorsOnAlley = visitorsOnAlley;
    }

    public ObservableList<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(ObservableList<Attraction> attractions) {
        this.attractions = attractions;
    }

    public ObservableList<Visitor> getVisitors() {
        return visitors;
    }

    public void setVisitors(ObservableList<Visitor> visitors) {
        this.visitors = visitors;
    }

    private void deleteVisitorFromMainAlley() {

    }
}
